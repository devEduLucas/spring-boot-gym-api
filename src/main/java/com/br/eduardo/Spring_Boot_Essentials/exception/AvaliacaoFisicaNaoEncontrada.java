package com.br.eduardo.Spring_Boot_Essentials.exception;

public class AvaliacaoFisicaNaoEncontrada extends RecursoNaoEncontradoException {
    public AvaliacaoFisicaNaoEncontrada(String mensagem){
        super(mensagem);
    }
}
