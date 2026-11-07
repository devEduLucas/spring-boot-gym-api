package com.br.eduardo.Spring_Boot_Essentials.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.eduardo.Spring_Boot_Essentials.database.model.TreinoEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.ITreinoRepository;
import com.br.eduardo.Spring_Boot_Essentials.dto.TreinoDto;
import com.br.eduardo.Spring_Boot_Essentials.exception.TreinoNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class TreinoService {
     private final ITreinoRepository treinoRepository;

    public List<TreinoEntity> getTreinos() {
        return treinoRepository.findAll();
    }

    public TreinoEntity getTreinoById(Long id) {
        return treinoRepository.findById(id)
                .orElseThrow(() -> new TreinoNaoEncontradoException("Treino não encontrado!"));
    }

    public void createTreino(TreinoDto treinoDto) {

        TreinoEntity treinoEntity = TreinoEntity.builder()
                .nome(treinoDto.getNome())
                .descricao(treinoDto.getDescricao())
                .build();

        treinoRepository.save(treinoEntity);
    }

    public void updateTreino(Long id, TreinoDto treinoDto) {

        TreinoEntity treinoEntity = treinoRepository.findById(id)
                .orElseThrow(() -> new TreinoNaoEncontradoException("Treino não encontrado!"));

        treinoEntity.setNome(treinoDto.getNome());
        treinoEntity.setDescricao(treinoDto.getDescricao());

        treinoRepository.save(treinoEntity);
    }

    public void deleteTreino(Long id) {

        if (!treinoRepository.existsById(id)) {
            throw new TreinoNaoEncontradoException("Treino não encontrado!");
        }

        treinoRepository.deleteById(id);
    }
}