package com.br.eduardo.Spring_Boot_Essentials.dto;

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
@Builder 
@ToString 

public class AlunoTreinoDto {
    @NotNull(message = "Aluno treino deve pertencer a algum aluno!")
    private Long alunoId;
    
    @NotNull(message = "Aluno treino deve pertencer a algum treino")
    private Long treinoId;

    @NotNull 
    private LocalDate dataInicio;
}
