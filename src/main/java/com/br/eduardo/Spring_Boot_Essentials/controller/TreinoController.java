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

import com.br.eduardo.Spring_Boot_Essentials.database.model.TreinoEntity;
import com.br.eduardo.Spring_Boot_Essentials.dto.TreinoDto;
import com.br.eduardo.Spring_Boot_Essentials.service.TreinoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/treino")
public class TreinoController {

    private final TreinoService treinoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TreinoEntity> findAllTreinos() {
        return treinoService.getTreinos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TreinoEntity findTreinoById(@PathVariable Long id) {
        return treinoService.getTreinoById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> createTreino(@Valid @RequestBody TreinoDto treinoDto) {
        treinoService.createTreino(treinoDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Treino cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTreino(@PathVariable Long id, @Valid @RequestBody TreinoDto treinoDto) {
        treinoService.updateTreino(id, treinoDto);

        return ResponseEntity.status(HttpStatus.OK)
        .body("Treino atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTreino(@PathVariable Long id) {
        treinoService.deleteTreino(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body("Treino deletado com sucesso!");
    }
}