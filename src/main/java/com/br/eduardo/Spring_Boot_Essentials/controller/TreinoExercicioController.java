package com.br.eduardo.Spring_Boot_Essentials.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.eduardo.Spring_Boot_Essentials.database.model.TreinoExercicioEntity;
import com.br.eduardo.Spring_Boot_Essentials.dto.TreinoExercicioDto;
import com.br.eduardo.Spring_Boot_Essentials.service.TreinoExercicioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/treino-exercicio")
public class TreinoExercicioController {

    private final TreinoExercicioService treinoExercicioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TreinoExercicioEntity> findAll() {
        return treinoExercicioService.getTreinoExercicios();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TreinoExercicioEntity findById(@PathVariable Long id) {
        return treinoExercicioService.getTreinoExercicioById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> create(@Valid @RequestBody TreinoExercicioDto treinoExercicioDto) {
        treinoExercicioService.createTreinoExercicio(treinoExercicioDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Exercício adicionado ao treino com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody TreinoExercicioDto dto) {

        treinoExercicioService.updateTreinoExercicio(id, dto);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Exercício atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTreinoExercicioById(@PathVariable Long id) {
        treinoExercicioService.deleteTreinoExercicio(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Exercício deletado do treino com sucesso!");
    }
}