package com.br.eduardo.Spring_Boot_Essentials.exception;

public class ProfessorNaoEncontradoException extends RecursoNaoEncontradoException {
    public ProfessorNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
