package com.br.eduardo.Spring_Boot_Essentials.exception;

public class TreinoNaoEncontradoException extends RecursoNaoEncontradoException {
    public TreinoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
