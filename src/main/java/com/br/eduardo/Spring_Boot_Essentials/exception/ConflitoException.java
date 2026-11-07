package com.br.eduardo.Spring_Boot_Essentials.exception;

/** Base das exceções de conflito com dados existentes (HTTP 409). */
public abstract class ConflitoException extends RuntimeException {
    protected ConflitoException(String mensagem){
        super(mensagem);
    }
}
