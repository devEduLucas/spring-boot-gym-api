package com.br.eduardo.Spring_Boot_Essentials.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.eduardo.Spring_Boot_Essentials.database.model.ExercicioEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IExercicioRepository;
import com.br.eduardo.Spring_Boot_Essentials.dto.ExercicioDto;
import com.br.eduardo.Spring_Boot_Essentials.exception.ExercicioNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class ExercicioService {

    private final IExercicioRepository exercicioRepository;

    public ExercicioEntity getExercicioById(Long id) {
    return exercicioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Exercício não encontrado!"));
    }

    public List<ExercicioEntity> getExercicios() {
        return exercicioRepository.findAll();
    }

    public void createExercicio(ExercicioDto exercicioDto) {

        ExercicioEntity exercicioEntity = ExercicioEntity.builder()
            .nome(exercicioDto.getNome())
            .grupoMuscular(exercicioDto.getGrupoMuscular())
            .build();

        exercicioRepository.save(exercicioEntity);
    }

     public void updateExercicio(Long id, ExercicioDto exercicioDto) {

        ExercicioEntity exercicioEntity = exercicioRepository.findById(id)
                .orElseThrow(() -> new ExercicioNaoEncontradoException("Exercício não encontrado!"));

        exercicioEntity.setNome(exercicioDto.getNome());
        exercicioEntity.setGrupoMuscular(exercicioDto.getGrupoMuscular());

        exercicioRepository.save(exercicioEntity);
    }

     public void deleteExercicio(Long id) {

        if (!exercicioRepository.existsById(id)) {
            throw new ExercicioNaoEncontradoException("Exercício não encontrado!");
        }

        exercicioRepository.deleteById(id);
    }
}