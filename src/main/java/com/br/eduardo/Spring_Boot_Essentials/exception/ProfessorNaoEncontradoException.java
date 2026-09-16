package com.br.eduardo.Spring_Boot_Essentials.exception;

public class ProfessorNaoEncontradoException extends RuntimeException{
    public ProfessorNaoEncontradoException(String Mensagem){
        super(Mensagem);
    }
}
