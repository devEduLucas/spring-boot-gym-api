package com.br.eduardo.Spring_Boot_Essentials.exception;

public class TreinoNaoEncontradoException extends RuntimeException{
    public TreinoNaoEncontradoException(String Mensagem){
        super(Mensagem);
    }
}
