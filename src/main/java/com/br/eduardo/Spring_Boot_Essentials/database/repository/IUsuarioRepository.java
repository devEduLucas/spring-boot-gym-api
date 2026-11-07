package com.br.eduardo.Spring_Boot_Essentials.database.repository;

import com.br.eduardo.Spring_Boot_Essentials.database.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    boolean existsByEmail(String email);

    Optional<UsuarioEntity> findByEmail(String email);
}
