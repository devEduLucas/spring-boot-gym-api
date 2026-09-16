package com.br.eduardo.Spring_Boot_Essentials.exception;

public class AlunoNaoEncontradoException extends RuntimeException{
    public AlunoNaoEncontradoException(String Mensagem){
        super(Mensagem);
    }
}
