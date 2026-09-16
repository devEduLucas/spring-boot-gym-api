package com.br.eduardo.Spring_Boot_Essentials.controller;

import org.springframework.web.bind.annotation.RestController;

import com.br.eduardo.Spring_Boot_Essentials.database.model.ExercicioEntity;
import com.br.eduardo.Spring_Boot_Essentials.dto.ExercicioDto;
import com.br.eduardo.Spring_Boot_Essentials.service.ExercicioService;

import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;



@RestController 
@RequiredArgsConstructor 
@RequestMapping("/v1/exercicio")

public class ExercicioController {

    private final ExercicioService exercicioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExercicioEntity> findAllExercicios() {
        return exercicioService.getExercicios();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createExercicio(@Valid @RequestBody ExercicioDto exercicioDto) {

        exercicioService.createExercicio(exercicioDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Exercício cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateExercicio(@PathVariable Long id, @Valid @RequestBody ExercicioDto exercicioDto) {
        exercicioService.updateExercicio(id, exercicioDto);

        return ResponseEntity.status(HttpStatus.OK)
        .body("Exercicio atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExercicio(@PathVariable Long id) {
        exercicioService.deleteExercicio(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body("Exercicio deletado com sucesso!");
    }
}