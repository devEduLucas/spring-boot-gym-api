package com.br.eduardo.Spring_Boot_Essentials.exception;

public class PesoImproprioException extends RuntimeException{
    public PesoImproprioException(String Mensagem){
        super(Mensagem);
    }
}
