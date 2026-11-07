package com.br.eduardo.Spring_Boot_Essentials.exception;

public class TreinoExercicioNaoEncontradoException extends RecursoNaoEncontradoException {
    public TreinoExercicioNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
