package com.br.eduardo.Spring_Boot_Essentials.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eduardo.Spring_Boot_Essentials.database.model.AlunoEntity;

public interface IAlunoRepository extends JpaRepository<AlunoEntity, Long> {
    boolean existsByEmail(String email);
}
