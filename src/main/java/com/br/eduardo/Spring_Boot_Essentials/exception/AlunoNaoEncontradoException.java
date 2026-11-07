package com.br.eduardo.Spring_Boot_Essentials.exception;

public class AlunoNaoEncontradoException extends RecursoNaoEncontradoException {
    public AlunoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
