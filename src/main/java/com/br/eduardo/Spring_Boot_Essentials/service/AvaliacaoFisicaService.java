package com.br.eduardo.Spring_Boot_Essentials.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.br.eduardo.Spring_Boot_Essentials.database.model.AlunoEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.model.AvaliacaoFisicaEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IAlunoRepository;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IAvaliacaoFisicaRepository;
import com.br.eduardo.Spring_Boot_Essentials.dto.AvaliacaoFisicaDto;
import com.br.eduardo.Spring_Boot_Essentials.dto.AvaliacaoFisicaProjection;
import com.br.eduardo.Spring_Boot_Essentials.exception.AlturaImpropriaException;
import com.br.eduardo.Spring_Boot_Essentials.exception.AlunoComAvaliacaoFisica;
import com.br.eduardo.Spring_Boot_Essentials.exception.AlunoNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.AvaliacaoFisicaNaoEncontrada;
import com.br.eduardo.Spring_Boot_Essentials.exception.PercentualGorduraImproprio;
import com.br.eduardo.Spring_Boot_Essentials.exception.PesoImproprioException;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 

public class AvaliacaoFisicaService {
    private final IAvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final IAlunoRepository alunoRepository;

    public List<AvaliacaoFisicaEntity> getAvaliacaoFisica(){
        return avaliacaoFisicaRepository.findAll();
    }

    public AvaliacaoFisicaEntity getAvaliacaoFisicaById(Long id){
        return avaliacaoFisicaRepository.findById(id)
        .orElseThrow(() -> new AvaliacaoFisicaNaoEncontrada("Avaliação física não encontrada"));
    }

    public List<AvaliacaoFisicaProjection> getAllAvaliacaoFisica(){
        return avaliacaoFisicaRepository.getAllAvaliacoes();
    }

    public Page<AvaliacaoFisicaProjection> getAllAvaliacaoFisicaPage(Integer size, Integer page){
        return avaliacaoFisicaRepository.getAllavaliacoesPage(PageRequest.of(size, page));
    }

    public void createAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto){
        if(avaliacaoFisicaDto.getPeso().compareTo(BigDecimal.ZERO) <= 0){
            throw new PesoImproprioException("Peso inválido! Deve ser maior que 0 KG");
        }else if(avaliacaoFisicaDto.getPeso().compareTo(new BigDecimal("500")) > 0){
            throw new PesoImproprioException("Peso Inválido! Deve ser menor que 500 KG");
        }

        if(avaliacaoFisicaDto.getAltura().compareTo(new BigDecimal("0.50")) < 0){
            throw new AlturaImpropriaException("Altura inválida! Deve ser maior que 0,50 M.");
        }else if(avaliacaoFisicaDto.getAltura().compareTo(new BigDecimal("2.50")) > 0 ){
            throw new AlturaImpropriaException("Altura inválida! Deve ser menor que 2,50 M.");
        }

        if(avaliacaoFisicaDto.getPercentualGordura().compareTo(BigDecimal.ZERO) <= 0){
            throw new PercentualGorduraImproprio("Percentual de gordura Inválido! Deve ser maior que 0.");
        }else if(avaliacaoFisicaDto.getPercentualGordura().compareTo(new BigDecimal("100")) > 0){
            throw new PercentualGorduraImproprio("Percentual de gordura Inválido! Deve ser menor que 100.");
        }

        if(avaliacaoFisicaRepository.existsById(avaliacaoFisicaDto.getAlunoId())){
            throw new AlunoComAvaliacaoFisica("Este aluno já tem uma avaliação física!");
        }

        AlunoEntity aluno = alunoRepository.findById(avaliacaoFisicaDto.getAlunoId())
        .orElseThrow(() -> new AlunoNaoEncontradoException("Aluno não encontrado!"));

        AvaliacaoFisicaEntity avaliacaoFisicaEntity = AvaliacaoFisicaEntity.builder()
        .peso(avaliacaoFisicaDto.getPeso())
        .altura(avaliacaoFisicaDto.getAltura())
        .percentualGordura(avaliacaoFisicaDto.getPercentualGordura())
        .dataAvaliacao(avaliacaoFisicaDto.getDataAvaliacao())
        .aluno(aluno)
        .build();
        
        avaliacaoFisicaRepository.save(avaliacaoFisicaEntity);
    }

    public void updateAvaliacaoFisica(Long id, AvaliacaoFisicaDto avaliacaoFisicaDto){
        if(avaliacaoFisicaDto.getPeso().compareTo(BigDecimal.ZERO) <= 0){
            throw new PesoImproprioException("Peso inválido! Deve ser maior que 0 KG");
        }else if(avaliacaoFisicaDto.getPeso().compareTo(new BigDecimal("500")) > 0){
            throw new PesoImproprioException("Peso Inválido! Deve ser menor que 500 KG");
        }

        if(avaliacaoFisicaDto.getAltura().compareTo(new BigDecimal("0.50")) < 0){
            throw new AlturaImpropriaException("Altura inválida! Deve ser maior que 0,50 M.");
        }else if(avaliacaoFisicaDto.getAltura().compareTo(new BigDecimal("2.50")) > 0 ){
            throw new AlturaImpropriaException("Altura inválida! Deve ser menor que 2,50 M.");
        }

        if(avaliacaoFisicaDto.getPercentualGordura().compareTo(BigDecimal.ZERO) <= 0){
            throw new PercentualGorduraImproprio("Percentual de gordura Inválido! Deve ser maior que 0.");
        }else if(avaliacaoFisicaDto.getPercentualGordura().compareTo(new BigDecimal("100")) > 0){
            throw new PercentualGorduraImproprio("Percentual de gordura Inválido! Deve ser menor que 100.");
        }

        AvaliacaoFisicaEntity avaliacaoFisica = avaliacaoFisicaRepository.findById(id)
        .orElseThrow(() -> new AvaliacaoFisicaNaoEncontrada("Avaliação física não encontrada!"));

        avaliacaoFisica.setPeso(avaliacaoFisicaDto.getPeso());
        avaliacaoFisica.setAltura(avaliacaoFisicaDto.getAltura());
        avaliacaoFisica.setPercentualGordura(avaliacaoFisicaDto.getPercentualGordura());
        avaliacaoFisica.setDataAvaliacao(avaliacaoFisicaDto.getDataAvaliacao());

        avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    public void deleteAvaliacaoFisica(Long id){
        if(!avaliacaoFisicaRepository.existsById(id)){
            throw new AvaliacaoFisicaNaoEncontrada("Avaliação física não encontrada!");
        }

        avaliacaoFisicaRepository.deleteById(id);
    }
}
