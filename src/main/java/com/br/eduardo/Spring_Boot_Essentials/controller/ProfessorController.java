package com.br.eduardo.Spring_Boot_Essentials.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.eduardo.Spring_Boot_Essentials.database.model.ProfessorEntity;
import com.br.eduardo.Spring_Boot_Essentials.dto.ProfessorDto;
import com.br.eduardo.Spring_Boot_Essentials.service.ProfessorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController 
@RequiredArgsConstructor 
@RequestMapping("/v1/professor")

public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorEntity> getAllProfessor(){
        return professorService.getProfessor();
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> createProfessor(@Valid @RequestBody ProfessorDto professorDto){

        professorService.createProfessor(professorDto);
    
        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Professor cadastrado com sucesso!");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProfessor(@PathVariable Long id, @Valid @RequestBody ProfessorDto professorDto){

        professorService.updateProfessor(id, professorDto);

        return ResponseEntity.status(HttpStatus.OK)
        .body("Professor atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessor(@PathVariable Long id){

        professorService.deleteProfessor(id);
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body("Professor deletado com sucesso!");
    }
}
