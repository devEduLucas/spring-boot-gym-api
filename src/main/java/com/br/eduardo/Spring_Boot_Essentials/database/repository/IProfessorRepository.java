package com.br.eduardo.Spring_Boot_Essentials.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eduardo.Spring_Boot_Essentials.database.model.ProfessorEntity;

public interface IProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}
