package com.br.eduardo.Spring_Boot_Essentials.exception;

public class EmailExistenteException extends RuntimeException{
    public EmailExistenteException(String Mensagem){
        super(Mensagem);    
    }
}
