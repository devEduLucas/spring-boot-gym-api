package com.br.eduardo.Spring_Boot_Essentials.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface AvaliacaoFisicaProjection {
    Long getAlunoId();

    String getNome();

    LocalDate getDataNascimento();

    BigDecimal getPeso();

    BigDecimal getAltura();

    BigDecimal getPercentualGordura();

    LocalDate getDataAvaliacao();
}
