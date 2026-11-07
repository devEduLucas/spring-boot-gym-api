package com.br.eduardo.Spring_Boot_Essentials.exception;

public class PesoImproprioException extends RegraNegocioException {
    public PesoImproprioException(String mensagem){
        super(mensagem);
    }
}
