package com.br.eduardo.Spring_Boot_Essentials.exception;

public class AlturaImpropriaException extends RuntimeException {
    public AlturaImpropriaException(String Mensagem){
        super(Mensagem);
    }
}
