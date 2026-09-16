package com.br.eduardo.Spring_Boot_Essentials.database.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
@Entity 
@Table(name = "avaliacao_fisica")

public class AvaliacaoFisicaEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    @Column(nullable = false)
    private BigDecimal peso;

    @Column(nullable = false)
    private BigDecimal altura;

    @Column(nullable = false, name = "percentual_gordura")
    private BigDecimal percentualGordura;

    @Column(nullable = false, name = "data_avaliacao")
    private LocalDate dataAvaliacao;

    @OneToOne
    @JoinColumn(name = "aluno_id", unique = true)
    @JsonIgnore 
    private AlunoEntity aluno;
}
