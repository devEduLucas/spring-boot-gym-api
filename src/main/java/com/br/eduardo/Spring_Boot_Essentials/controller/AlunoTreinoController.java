package com.br.eduardo.Spring_Boot_Essentials.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.eduardo.Spring_Boot_Essentials.database.model.AlunoTreinoEntity;
import com.br.eduardo.Spring_Boot_Essentials.dto.AlunoTreinoDto;
import com.br.eduardo.Spring_Boot_Essentials.service.AlunoTreinoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController 
@RequiredArgsConstructor 
@RequestMapping("/v1/aluno-treino")
public class AlunoTreinoController {
    
    private final AlunoTreinoService alunoTreinoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoTreinoEntity> getAllAlunoTreino(){
        return alunoTreinoService.getAlunoTreino();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoTreinoEntity getAlunoTreinoById(@PathVariable Long id){
        return alunoTreinoService.getAlunoTreinoById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> createAlunoTreino(@Valid @RequestBody AlunoTreinoDto alunoTreinoDto){
        alunoTreinoService.createAlunoTreino(alunoTreinoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Aluno treino criado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAlunoTreino(@PathVariable Long id, @Valid @RequestBody AlunoTreinoDto alunoTreinoDto){
        alunoTreinoService.updateAlunoTreino(id, alunoTreinoDto);

        return ResponseEntity.status(HttpStatus.OK)
        .body("Aluno ttreino atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlunoTreinoById(@PathVariable Long id){
        alunoTreinoService.deleteAlunoTreino(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body("Aluno deletado com sucesso");
    }
}
