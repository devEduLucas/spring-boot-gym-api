package com.br.eduardo.Spring_Boot_Essentials.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.eduardo.Spring_Boot_Essentials.database.model.AvaliacaoFisicaEntity;
import com.br.eduardo.Spring_Boot_Essentials.dto.AvaliacaoFisicaDto;
import com.br.eduardo.Spring_Boot_Essentials.dto.AvaliacaoFisicaProjection;
import com.br.eduardo.Spring_Boot_Essentials.service.AvaliacaoFisicaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
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
@RequestMapping("/v1/avaliacao-fisica")
public class AvaliacaoFisicaController {
    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacaoFisicaEntity getAvaliacaoFisicaById(@PathVariable Long id) {
        return avaliacaoFisicaService.getAvaliacaoFisicaById(id);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacaoFisicaEntity> getAllAvaliacaoFisica(){
        return avaliacaoFisicaService.getAvaliacaoFisica();
    }

    @GetMapping("/projection")
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacaoFisicaProjection> getAllAvaliacaoFisicaProjection(){
        return avaliacaoFisicaService.getAllAvaliacaoFisica();
    }

    @GetMapping("/page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public Page<AvaliacaoFisicaProjection> getAllAvaliacaoFisicaPage(@PathVariable Integer page, @PathVariable Integer size){
        return avaliacaoFisicaService.getAllAvaliacaoFisicaPage(page, size);
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> createAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto){
        avaliacaoFisicaService.createAvaliacaoFisica(avaliacaoFisicaDto);

        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Avaliação fisica criada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAvaliacaoFisica(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto){
        avaliacaoFisicaService.updateAvaliacaoFisica(id, avaliacaoFisicaDto);

        return ResponseEntity.status(HttpStatus.OK)
        .body("Avaliação fisica atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAvaliacaoFisicaById(@PathVariable Long id){
        avaliacaoFisicaService.deleteAvaliacaoFisica(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body("Avaliação física deletada com sucesso!");
    }
}
