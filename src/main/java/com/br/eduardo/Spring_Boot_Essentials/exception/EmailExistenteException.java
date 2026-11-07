package com.br.eduardo.Spring_Boot_Essentials.exception;

public class EmailExistenteException extends ConflitoException {
    public EmailExistenteException(String mensagem){
        super(mensagem);
    }
}
