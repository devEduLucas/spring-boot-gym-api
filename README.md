Spring Boot Essentials: API de Academia

API REST para gerenciar uma academia: alunos, professores, treinos, exercícios e avaliações físicas, com autenticação por JWT (Spring Security).

Projeto de estudo, em evolução. Esta página documenta o que já foi feito e o que está planejado.

Tecnologias
Java (versão definida no pom.xml) e Spring Boot
Spring Web, Spring Data JPA (Hibernate) e MySQL
Bean Validation (jakarta.validation)
Spring Security + JWT (biblioteca jjwt 0.12.6)
Lombok
JUnit 5
Arquitetura

O projeto é organizado em camadas. Uma requisição segue este caminho:

Controller  →  Service  →  Repository  →  Banco (MySQL)
 (rotas e     (regras de    (Spring Data
  validação)   negócio)      JPA)
src/main/java/com/br/eduardo/Spring_Boot_Essentials
├── config/        SecurityConfig e JwtAuthenticationFilter
├── controller/    endpoints REST
├── database/
│   ├── model/        entidades JPA
│   └── repository/   repositórios Spring Data
├── dto/           objetos de entrada e saída da API
├── exception/     exceções de negócio, agrupadas por classe-mãe
├── handler/       ErrorGlobal (@RestControllerAdvice)
└── service/       regras de negócio, AuthService e JwtService
Modelo de dados
Entidade	Relação
Professor	tem vários alunos
Aluno	pertence a um professor; tem uma avaliação física
AvaliacaoFisica	uma por aluno
Treino e Exercicio	catálogo
AlunoTreino	liga aluno a treino (com data de início)
TreinoExercicio	liga treino a exercício (séries, repetições e carga)
Usuario	credenciais de acesso (e-mail e senha em hash BCrypt)
O que já foi feito
CRUD e regras de negócio
CRUD de aluno, professor, treino, exercício, avaliação física, aluno-treino e treino-exercício.
Validações de negócio: idade mínima do aluno, e-mail único, limites de peso, altura e percentual de gordura, uma avaliação física por aluno.
Consulta de avaliações com query nativa, projeção de interface e paginação.
@Transactional nas atualizações que dependem de dirty checking.
Tratamento de erros

Exceções agrupadas em classes-mãe e tratadas em um único ErrorGlobal:

Status	Classe-mãe	Exemplos
400	RegraNegocioException	peso, altura ou data de nascimento inválidos
401	CredenciaisInvalidasException	e-mail ou senha incorretos no login
404	RecursoNaoEncontradoException	aluno, treino ou professor inexistente
409	ConflitoException	e-mail já cadastrado, aluno que já tem avaliação
Segurança (Spring Security + JWT)
SecurityConfig com sessão STATELESS, CSRF desabilitado (a API usa token no header, não cookie) e todas as rotas protegidas, exceto /auth/** e /error.
Cadastro de usuário com senha em hash BCrypt.
POST /auth/login que devolve um token JWT assinado, com validade de 1 hora.
JwtAuthenticationFilter: lê o header Authorization: Bearer <token>, valida o token e identifica o usuário. Sem token válido, a API responde 401.
Testes unitários do JwtService (token válido, expirado e assinado com outro segredo).
Como executar
Pré-requisitos
JDK compatível com o pom.xml
Maven
MySQL em execução
Variáveis de ambiente
Variável	Descrição
DB_URL	URL JDBC, por exemplo jdbc:mysql://localhost:3306/<nome_do_banco>
DB_USER	usuário do banco
DB_PASSWORD	senha do banco
JWT_SECRET	segredo para assinar os tokens, com no mínimo 32 caracteres

Para gerar um segredo: openssl rand -base64 48. Nunca versione o valor do segredo. Se ele vazar, qualquer pessoa consegue gerar tokens válidos; a correção é trocá-lo, o que invalida todos os tokens existentes.

Banco de dados

O ddl-auto não está configurado, então o Hibernate não cria as tabelas. Crie-as antes de subir a aplicação. A tabela de usuários:

sql
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

As demais tabelas seguem as entidades em database/model. Um script SQL completo está no roadmap.

Subir a aplicação
bash
mvn spring-boot:run

A API sobe na porta 8082.

Endpoints
Autenticação (livres)
Método	Rota	Descrição
POST	/auth/register	cadastra um usuário
POST	/auth/login	devolve {"token": "..."}

Exemplo:

bash
curl -X POST http://localhost:8082/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email": "usuario@email.com", "senha": "minhaSenha1"}'
Demais rotas (exigem token)

Envie o header Authorization: Bearer <token>.

Recurso	Rota base	Operações
Aluno	/v1/aluno	listar, /register, PUT /{id}, DELETE /{id}
Professor	/v1/professor	listar, /register, PUT /{id}, DELETE /{id}
Treino	/v1/treino	listar, buscar por id, /register, PUT /{id}, DELETE /{id}
Exercício	/v1/exercicio	listar, /register, PUT /{id}, DELETE /{id}
Aluno-treino	/v1/aluno-treino	listar, buscar por id, /register, PUT /{id}, DELETE /{id}
Treino-exercício	/v1/treino-exercicio	listar, buscar por id, /register, PUT /{id}, DELETE /{id}
Avaliação física	/v1/avaliacao-fisica	listar, buscar por id, /projection, /page/{page}/size/{size}, /register, PUT /{id}, DELETE /{id}
Roadmap

Itens planejados, em ordem aproximada:

Segurança

 Papéis (aluno e professor) e autorização por perfil.
 Decidir como vincular o usuário autenticado às entidades Aluno e Professor.

Qualidade

 Testes unitários dos services com JUnit e Mockito.
 Testes de integração dos endpoints, incluindo os cenários de segurança (401 e 200).
 Revisar o tratamento de exclusão de registros com dados relacionados (hoje gera erro de chave estrangeira).

API

 DTOs de resposta, em vez de devolver entidades diretamente.
 Paginação nas demais listagens.
 Validações de faixa (peso, altura, gordura) com Bean Validation nos DTOs.

Infraestrutura

 Script SQL completo ou migrations (Flyway) no lugar da criação manual das tabelas.
 Profiles de configuração (dev e produção).
 Docker e docker-compose com MySQL.
 Documentação da API com OpenAPI.

Organização

 Renomear o pacote Spring_Boot_Essentials para o padrão Java (minúsculas, sem underscore) e os repositórios com prefixo I.
