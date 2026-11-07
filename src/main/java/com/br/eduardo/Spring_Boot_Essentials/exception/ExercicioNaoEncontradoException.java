package com.br.eduardo.Spring_Boot_Essentials.exception;

public class ExercicioNaoEncontradoException extends RecursoNaoEncontradoException {
    public ExercicioNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
