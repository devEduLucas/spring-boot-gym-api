package com.br.eduardo.Spring_Boot_Essentials.exception;

/** Base das exceções de regra de negócio violada (HTTP 400). */
public abstract class RegraNegocioException extends RuntimeException {
    protected RegraNegocioException(String mensagem){
        super(mensagem);
    }
}
