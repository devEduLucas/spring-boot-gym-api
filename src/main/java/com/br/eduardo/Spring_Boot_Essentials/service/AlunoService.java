package com.br.eduardo.Spring_Boot_Essentials.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.eduardo.Spring_Boot_Essentials.database.model.AlunoEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.model.ProfessorEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IAlunoRepository;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IProfessorRepository;
import com.br.eduardo.Spring_Boot_Essentials.dto.AlunoDto;
import com.br.eduardo.Spring_Boot_Essentials.exception.AlunoNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.DataNascimentoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.EmailExistenteException;
import com.br.eduardo.Spring_Boot_Essentials.exception.ProfessorNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AlunoService {
    private final IAlunoRepository alunoRepository;
    private final IProfessorRepository professorRepository;
    
    public List<AlunoEntity> getAlunos(){
        return alunoRepository.findAll();
    }

    public void createAluno(AlunoDto alunoDto){

        LocalDate today = LocalDate.now();

        int idade = Period.between(alunoDto.getDataNascimento(), today).getYears();

        ProfessorEntity professor = professorRepository.findById(alunoDto.getProfessorId())
        .orElseThrow(() -> new ProfessorNaoEncontradoException("Professor não encontrado!"));

        if(idade < 18){
            throw new DataNascimentoException("É preciso ter 18 anos para se cadastrar!");
        }

        if(alunoRepository.existsByEmail(alunoDto.getEmail())){
            throw new EmailExistenteException("E-mail já cadastrado!");
        }

        AlunoEntity alunoEntity = AlunoEntity.builder()
        .nome(alunoDto.getNome())
        .email(alunoDto.getEmail())
        .dataNascimento(alunoDto.getDataNascimento())
        .professor(professor)   
        .build();

        alunoRepository.save(alunoEntity);
    }

    public void updateAluno(Long id, AlunoDto alunoDto){

        LocalDate today = LocalDate.now();

        int idade = Period.between(alunoDto.getDataNascimento(), today).getYears();

        AlunoEntity alunoEntity = alunoRepository.findById(id)
        .orElseThrow(() -> new AlunoNaoEncontradoException("Aluno não encontrado"));

        if(idade < 18){
            throw new DataNascimentoException("É preciso ter 18 anos para se cadastrar!");
        }

        if(alunoRepository.existsByEmailAndIdNot(alunoDto.getEmail(), id)){
            throw new EmailExistenteException("E-mail já cadastrado!");
        }

        ProfessorEntity professor = professorRepository.findById(alunoDto.getProfessorId())
        .orElseThrow(() -> new ProfessorNaoEncontradoException("Professor não encontrado!"));

        alunoEntity.setNome(alunoDto.getNome());
        alunoEntity.setEmail(alunoDto.getEmail());
        alunoEntity.setDataNascimento(alunoDto.getDataNascimento());
        alunoEntity.setProfessor(professor);

        alunoRepository.save(alunoEntity);
    }

    public void deleteAluno(Long id){
        if(!alunoRepository.existsById(id)){
            throw new AlunoNaoEncontradoException("Aluno não encontrado");
        }

        alunoRepository.deleteById(id);
    }
}
