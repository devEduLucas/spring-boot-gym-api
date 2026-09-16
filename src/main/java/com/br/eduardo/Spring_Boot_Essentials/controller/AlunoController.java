package com.br.eduardo.Spring_Boot_Essentials.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.eduardo.Spring_Boot_Essentials.database.model.AlunoEntity;
import com.br.eduardo.Spring_Boot_Essentials.dto.AlunoDto;
import com.br.eduardo.Spring_Boot_Essentials.service.AlunoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/aluno")

public class AlunoController {
    private final AlunoService alunoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoEntity> findAllAlunos() {
        return alunoService.getAlunos();
    }

    @PostMapping("/register")
    public ResponseEntity<String> createAluno(@Valid @RequestBody AlunoDto alunoDto) {
        alunoService.createAluno(alunoDto);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Aluno cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAluno(@PathVariable Long id, @Valid @RequestBody AlunoDto alunoDto) {
        alunoService.updateAluno(id, alunoDto);
        return ResponseEntity.status(HttpStatus.OK)
        .body("Aluno atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteAlunoById(@PathVariable Long id){
        alunoService.deleteAluno(id);

        return ResponseEntity.ok("Aluno deletado com sucesso!");
    }
}
