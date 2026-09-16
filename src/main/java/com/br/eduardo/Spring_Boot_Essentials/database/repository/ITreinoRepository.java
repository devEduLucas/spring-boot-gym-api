package com.br.eduardo.Spring_Boot_Essentials.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eduardo.Spring_Boot_Essentials.database.model.TreinoEntity;

public interface ITreinoRepository extends JpaRepository<TreinoEntity, Long>{
}
