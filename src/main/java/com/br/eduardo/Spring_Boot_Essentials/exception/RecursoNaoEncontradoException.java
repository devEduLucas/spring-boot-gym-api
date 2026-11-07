package com.br.eduardo.Spring_Boot_Essentials.exception;

/** Base das exceções de "não encontrado" (HTTP 404). */
public abstract class RecursoNaoEncontradoException extends RuntimeException {
    protected RecursoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
