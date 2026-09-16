package com.br.eduardo.Spring_Boot_Essentials.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.eduardo.Spring_Boot_Essentials.database.model.ProfessorEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IProfessorRepository;
import com.br.eduardo.Spring_Boot_Essentials.dto.ProfessorDto;
import com.br.eduardo.Spring_Boot_Essentials.exception.ProfessorNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 

public class ProfessorService {
    private final IProfessorRepository professorRepository;
    
    public List<ProfessorEntity> getProfessor(){
        return professorRepository.findAll();
    }

    public void createProfessor(ProfessorDto professorDto){

        ProfessorEntity professorEntity = ProfessorEntity.builder()
        .nome(professorDto.getNome())
        .especialidade(professorDto.getEspecialidade())
        .build();

        professorRepository.save(professorEntity);
    }

    public void updateProfessor(Long id, ProfessorDto professorDto){

        ProfessorEntity professorEntity = professorRepository.findById(id)
        .orElseThrow(() -> new ProfessorNaoEncontradoException("Professor não encontrado!"));

        professorEntity.setNome(professorDto.getNome());
        professorEntity.setEspecialidade(professorDto.getEspecialidade());
    }

    public void deleteProfessor(Long id){
        if(!professorRepository.existsById(id)){
            throw new ProfessorNaoEncontradoException("Professor não encontrado!");
        }

        professorRepository.deleteById(id);
    }
}
