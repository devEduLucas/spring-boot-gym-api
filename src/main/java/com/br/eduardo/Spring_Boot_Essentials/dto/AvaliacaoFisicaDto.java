package com.br.eduardo.Spring_Boot_Essentials.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString 
@Builder

public class AvaliacaoFisicaDto {
    @NotNull 
    private BigDecimal peso;

    @NotNull 
    private BigDecimal altura;

    @NotNull 
    private BigDecimal percentualGordura;

    @NotNull 
    private LocalDate dataAvaliacao;

    @NotNull(message = "Avaliação física deve percentecer a algum aluno!")
    private Long alunoId;
}
