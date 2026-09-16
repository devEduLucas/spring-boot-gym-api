package com.br.eduardo.Spring_Boot_Essentials.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class AlunoDto {
    
    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull(message = "Professor é obrigatório")
    private Long professorId;
}
