package com.br.eduardo.Spring_Boot_Essentials.database.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "treino_exercicio")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreinoExercicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer series;

    private Integer repeticoes;

    private BigDecimal carga;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    private TreinoEntity treino;

    @ManyToOne
    @JoinColumn(name = "exercicio_id")
    private ExercicioEntity exercicio;
}