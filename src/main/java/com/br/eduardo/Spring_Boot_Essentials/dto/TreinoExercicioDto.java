package com.br.eduardo.Spring_Boot_Essentials.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TreinoExercicioDto {

    private Integer series;

    private Integer repeticoes;

    private BigDecimal carga;

    private Long treinoId;

    private Long exercicioId;
}