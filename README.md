# 🏋️ Spring Boot Gym API

REST API para gerenciamento de uma academia, desenvolvida com **Java e Spring Boot**.

O projeto tem como objetivo aplicar na prática conceitos de desenvolvimento backend, incluindo criação de APIs REST, arquitetura em camadas, persistência de dados, relacionamentos entre entidades, validações, paginação e projections.

---

## 🚀 Tecnologias

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Jakarta Validation

### 🔜 Em breve

- Spring Security
- BCrypt
- Autenticação com JWT
- Autorização por perfis
- Proteção dos endpoints

---

## 📁 Estrutura do projeto

```text
src/main/java
└── com.br.eduardo.Spring_Boot_Essentials
    ├── config
    ├── controller
    ├── service
    ├── dto
    ├── database
    │   ├── model
    │   └── repository
    └── handler
    └── exception

Controller
Responsável por receber as requisições HTTP e retornar as respostas da API.

Service
Responsável pelas regras de negócio e validações da aplicação.

Repository
Responsável pela comunicação com o banco de dados utilizando Spring Data JPA.

Entity
Representa as entidades persistidas no banco de dados.

DTO
Objetos utilizados para transportar os dados recebidos pela API.

Handler
Responsável pelo tratamento centralizado das exceções personalizadas da aplicação.

Exception
As exceções são tratadas e convertidas em respostas HTTP apropriadas para o cliente da API.

## 🗄️ Banco de dados

O projeto utiliza **MySQL**.

Banco utilizado:

gym_system

### Principais entidades

- Professor
- Aluno
- Avaliação Física
- Treino
- Exercício
- AlunoTreino
- TreinoExercicio

### Relacionamentos

Professor 1:N Aluno

Aluno 1:1 AvaliacaoFisica

Aluno N:N Treino
       │
       └── AlunoTreino

Treino N:N Exercicio
       │
       └── TreinoExercicio

As entidades `AlunoTreino` e `TreinoExercicio` representam os relacionamentos muitos-para-muitos entre alunos e treinos, e entre treinos e exercícios.

---

## 🔗 Endpoints

### 👤 Alunos

GET    /v1/alunos
POST   /v1/alunos/register
PUT    /v1/alunos/{id}
DELETE /v1/alunos/{id}

### 👨‍🏫 Professores

GET    /v1/professores
POST   /v1/professores
PUT    /v1/professores/{id}
DELETE /v1/professores/{id}

### 📊 Avaliações físicas

GET    /v1/avaliacoes-fisicas
POST   /v1/avaliacoes-fisicas
PUT    /v1/avaliacoes-fisicas/{id}
DELETE /v1/avaliacoes-fisicas/{id}

A consulta de avaliações físicas utiliza Projection e paginação.

### 🏋️ Treinos

GET    /v1/treinos
GET    /v1/treinos/{id}
POST   /v1/treinos
PUT    /v1/treinos/{id}
DELETE /v1/treinos/{id}

### 💪 Exercícios

GET    /v1/exercicios
GET    /v1/exercicios/{id}
POST   /v1/exercicios
PUT    /v1/exercicios/{id}
DELETE /v1/exercicios/{id}

### 🔗 Aluno x Treino

GET    /v1/aluno-treino
GET    /v1/aluno-treino/{id}
POST   /v1/aluno-treino
PUT    /v1/aluno-treino/{id}
DELETE /v1/aluno-treino/{id}

### 🔗 Treino x Exercício

GET    /v1/treino-exercicios
GET    /v1/treino-exercicios/{id}
POST   /v1/treino-exercicios
PUT    /v1/treino-exercicios/{id}
DELETE /v1/treino-exercicios/{id}

---

## 📑 Paginação

A API utiliza os recursos de paginação do Spring Data para controlar a quantidade de registros retornados nas consultas.

A implementação utiliza `Page` e `Pageable`, permitindo controlar a página atual e a quantidade de registros por página.

---

## 🔎 Projection

O projeto utiliza **Spring Data Projection** para retornar somente os dados necessários em determinadas consultas, evitando o retorno de informações desnecessárias.

As projections são utilizadas principalmente na consulta de avaliações físicas, reunindo informações do aluno e de sua avaliação física.

Exemplo de retorno:

```json
{
    "alunoId": 2,
    "nome": "Eduardo",
    "dataNascimento": "2008-06-26",
    "peso": 84.00,
    "altura": 1.85,
    "percentualGordura": 15.50,
    "dataAvaliacao": "2026-09-13"
}

## ✅ Validações

A aplicação possui validações de regras de negócio para garantir a integridade dos dados.

Entre as validações implementadas estão:

- E-mail não pode ser duplicado
- Aluno deve possuir idade mínima para cadastro
- Peso deve possuir um valor válido
- Altura deve possuir um valor válido
- Percentual de gordura deve estar dentro do intervalo permitido
- Um aluno não pode possuir mais de uma avaliação física
- O aluno precisa existir para receber uma avaliação física
- O treino precisa existir antes de receber um exercício
- O exercício precisa existir antes de ser associado a um treino

---

## ⚠️ Exception Handler

O projeto utiliza um `GlobalExceptionHandler` para centralizar o tratamento das exceções da aplicação.

Foram criadas exceções personalizadas para representar diferentes erros de negócio, como:

- Aluno não encontrado
- E-mail já cadastrado
- Data de nascimento inválida
- Peso inválido
- Altura inválida
- Percentual de gordura inválido
- Avaliação física já existente
- Treino não encontrado
- Exercício não encontrado

As exceções são interceptadas pelo `GlobalExceptionHandler` e transformadas em respostas HTTP apropriadas para o cliente da API.

---

## ⚙️ Configuração

### Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- Java
- Maven
- MySQL

### Banco de dados

Crie o banco de dados MySQL:

```sql
CREATE DATABASE gym_system;

## 🔐 Segurança

A implementação de autenticação e autorização será adicionada futuramente ao projeto.

### Planejado

- Spring Security
- BCrypt para hash de senhas
- Autenticação utilizando JWT
- Autorização por perfis de usuário
- Proteção dos endpoints

---

## 🛣️ Roadmap

- [x] CRUD de alunos
- [x] CRUD de professores
- [x] CRUD de avaliações físicas
- [x] CRUD de treinos
- [x] CRUD de exercícios
- [x] Relacionamento entre alunos e treinos
- [x] Relacionamento entre treinos e exercícios
- [x] Validações de regras de negócio
- [x] Exception Handler
- [x] Paginação
- [x] Projection
- [ ] Spring Security
- [ ] Autenticação com JWT
- [ ] Autorização por perfis
- [ ] Proteção dos endpoints

---

## 👨‍💻 Autor

**Eduardo Lucas de Oliveira**

Estudante de Desenvolvimento de Sistemas e desenvolvedor backend em formação.

### Tecnologias de interesse

Java • Spring Boot • REST APIs • JPA • MySQL • Backend

---