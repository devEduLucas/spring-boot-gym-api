package com.br.eduardo.Spring_Boot_Essentials.exception;

public class AlunoTreinoNaoEncontradoException extends RecursoNaoEncontradoException {
    public AlunoTreinoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
