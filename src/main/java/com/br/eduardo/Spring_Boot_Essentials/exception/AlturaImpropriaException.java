package com.br.eduardo.Spring_Boot_Essentials.exception;

public class AlturaImpropriaException extends RegraNegocioException {
    public AlturaImpropriaException(String mensagem){
        super(mensagem);
    }
}
