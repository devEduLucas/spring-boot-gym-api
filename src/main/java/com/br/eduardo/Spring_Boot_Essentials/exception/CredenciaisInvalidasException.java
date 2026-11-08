package com.br.eduardo.Spring_Boot_Essentials.exception;

public class CredenciaisInvalidasException extends RuntimeException {
    public CredenciaisInvalidasException(String mensagem){
        super(mensagem);
    }
}