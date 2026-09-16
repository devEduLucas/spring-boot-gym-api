package com.br.eduardo.Spring_Boot_Essentials.exception;

public class ExercicioNaoEncontradoException extends RuntimeException{
    public ExercicioNaoEncontradoException(String Mensagem){
        super(Mensagem);
    }
}
