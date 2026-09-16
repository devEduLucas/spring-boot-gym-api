package com.br.eduardo.Spring_Boot_Essentials.database.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import com.br.eduardo.Spring_Boot_Essentials.database.model.AvaliacaoFisicaEntity;
import com.br.eduardo.Spring_Boot_Essentials.dto.AvaliacaoFisicaProjection;

public interface IAvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisicaEntity, Long> {
    @NativeQuery(value = """
            SELECT
            a.id AS alunoId,
            a.nome AS nome,
            a.email AS email,
            a.data_nascimento AS dataNascimento,
            af.peso AS peso,
            af.altura AS altura,
            af.percentual_gordura AS percentualGordura,
            af.data_avaliacao AS dataAvaliacao
            FROM avaliacao_fisica af
            INNER JOIN aluno a
            ON af.aluno_id = a.id
    """)

        List<AvaliacaoFisicaProjection> getAllAvaliacoes();

    @NativeQuery(value = """
            SELECT
            a.id AS alunoId,
            a.nome AS nome,
            a.email AS email,
            a.data_nascimento AS dataNascimento,
            af.peso AS peso,
            af.altura AS altura,
            af.percentual_gordura AS percentualGordura,
            af.data_avaliacao AS dataAvaliacao
            FROM avaliacao_fisica af
            INNER JOIN aluno a
            ON af.aluno_id = a.id
            """,
            countQuery = """
                    SELECT COUNT(af.id)
                    FROM avaliacao_fisica af
                    INNER JOIN aluno a
                    ON af.aluno_id = a.id
    """)

            Page<AvaliacaoFisicaProjection> getAllavaliacoesPage(Pageable pageable);
}
