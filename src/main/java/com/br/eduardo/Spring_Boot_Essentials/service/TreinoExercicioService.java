package com.br.eduardo.Spring_Boot_Essentials.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.eduardo.Spring_Boot_Essentials.database.model.ExercicioEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.model.TreinoEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.model.TreinoExercicioEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IExercicioRepository;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.ITreinoExercicioRepository;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.ITreinoRepository;
import com.br.eduardo.Spring_Boot_Essentials.dto.TreinoExercicioDto;
import com.br.eduardo.Spring_Boot_Essentials.exception.ExercicioNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.TreinoNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.TreinoExercicioNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TreinoExercicioService {

    private final ITreinoExercicioRepository treinoExercicioRepository;
    private final ITreinoRepository treinoRepository;
    private final IExercicioRepository exercicioRepository;

    public List<TreinoExercicioEntity> getTreinoExercicios() {
        return treinoExercicioRepository.findAll();
    }

    public TreinoExercicioEntity getTreinoExercicioById(Long id) {
        return treinoExercicioRepository.findById(id)
                .orElseThrow(() -> new TreinoExercicioNaoEncontradoException("Relação não encontrada!"));
    }

    // POST - Cadastrar
    public void createTreinoExercicio(TreinoExercicioDto treinoExercicioDto) {
        TreinoEntity treino = treinoRepository.findById(treinoExercicioDto.getTreinoId())
                .orElseThrow(() -> new TreinoNaoEncontradoException("Treino não encontrado!"));

        ExercicioEntity exercicio = exercicioRepository.findById(treinoExercicioDto.getExercicioId())
                .orElseThrow(() -> new ExercicioNaoEncontradoException("Exercício não encontrado!"));

        TreinoExercicioEntity entity = TreinoExercicioEntity.builder()
                .series(treinoExercicioDto.getSeries())
                .repeticoes(treinoExercicioDto.getRepeticoes())
                .carga(treinoExercicioDto.getCarga())
                .treino(treino)
                .exercicio(exercicio)
                .build();

        treinoExercicioRepository.save(entity);
    }

    public void updateTreinoExercicio(Long id, TreinoExercicioDto treinoExercicioDto) {

        TreinoExercicioEntity entity = treinoExercicioRepository.findById(id)
                .orElseThrow(() -> new TreinoExercicioNaoEncontradoException("Relação não encontrada!"));

        TreinoEntity treino = treinoRepository.findById(treinoExercicioDto.getTreinoId())
                .orElseThrow(() -> new TreinoNaoEncontradoException("Treino não encontrado!"));

        ExercicioEntity exercicio = exercicioRepository.findById(treinoExercicioDto.getExercicioId())
                .orElseThrow(() -> new ExercicioNaoEncontradoException("Exercício não encontrado!"));

        entity.setSeries(treinoExercicioDto.getSeries());
        entity.setRepeticoes(treinoExercicioDto.getRepeticoes());
        entity.setCarga(treinoExercicioDto.getCarga());
        entity.setTreino(treino);
        entity.setExercicio(exercicio);

        treinoExercicioRepository.save(entity);
    }

    public void deleteTreinoExercicio(Long id) {

        if (!treinoExercicioRepository.existsById(id)) {
            throw new TreinoExercicioNaoEncontradoException("Relação não encontrada!");
        }

        treinoExercicioRepository.deleteById(id);
    }
}