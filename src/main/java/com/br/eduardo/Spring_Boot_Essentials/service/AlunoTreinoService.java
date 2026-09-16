package com.br.eduardo.Spring_Boot_Essentials.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.eduardo.Spring_Boot_Essentials.database.model.AlunoEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.model.AlunoTreinoEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.model.TreinoEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IAlunoRepository;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IAlunoTreinoRepository;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.ITreinoRepository;
import com.br.eduardo.Spring_Boot_Essentials.dto.AlunoTreinoDto;
import com.br.eduardo.Spring_Boot_Essentials.exception.AlunoNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.AlunoTreinoNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.TreinoNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AlunoTreinoService {
    private final IAlunoTreinoRepository alunoTreinoRepository;
    private final IAlunoRepository alunoRepository;
    private final ITreinoRepository treinoRepository;

    public List<AlunoTreinoEntity> getAlunoTreino(){
        return alunoTreinoRepository.findAll();
    }

    public AlunoTreinoEntity getAlunoTreinoById(Long id){
        return alunoTreinoRepository.findById(id)
        .orElseThrow(() -> new AlunoTreinoNaoEncontradoException("Aluno Treino não encontrado!"));
    }

    public void createAlunoTreino(AlunoTreinoDto alunoTreinoDto){
        AlunoEntity aluno = alunoRepository.findById(alunoTreinoDto.getAlunoId())
        .orElseThrow(() -> new AlunoNaoEncontradoException("Aluno não encontrado!"));

        TreinoEntity treino = treinoRepository.findById(alunoTreinoDto.getTreinoId())
        .orElseThrow(() -> new TreinoNaoEncontradoException("Treino não encontrado!"));

        AlunoTreinoEntity alunoTreino = AlunoTreinoEntity.builder()
        .aluno(aluno)
        .treino(treino)
        .dataInicio(alunoTreinoDto.getDataInicio())
        .build();

        alunoTreinoRepository.save(alunoTreino);
    }   

    public void updateAlunoTreino(Long id, AlunoTreinoDto alunoTreinoDto){
        AlunoTreinoEntity alunoTreinoEntity = alunoTreinoRepository.findById(id)
        .orElseThrow(() -> new AlunoTreinoNaoEncontradoException("Aluno treino não encontrado!"));

        alunoTreinoEntity.setDataInicio(alunoTreinoDto.getDataInicio());
    }

    public void deleteAlunoTreino(Long id){
        if(!alunoTreinoRepository.existsById(id)){
            throw new AlunoTreinoNaoEncontradoException("Aluno treino não encontrado!");
        }

        alunoTreinoRepository.deleteById(id);
    }
}
