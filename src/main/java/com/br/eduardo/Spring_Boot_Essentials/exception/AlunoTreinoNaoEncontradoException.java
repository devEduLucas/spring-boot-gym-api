package com.br.eduardo.Spring_Boot_Essentials.exception;

public class AlunoTreinoNaoEncontradoException extends RuntimeException{
    public AlunoTreinoNaoEncontradoException(String Mensagem){
        super(Mensagem);
    }
}
