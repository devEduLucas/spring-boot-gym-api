package com.br.eduardo.Spring_Boot_Essentials.dto;

import jakarta.validation.constraints.NotBlank;
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
public class TreinoDto {
    @NotBlank 
    private String nome;

    @NotBlank 
    private String descricao;
}
