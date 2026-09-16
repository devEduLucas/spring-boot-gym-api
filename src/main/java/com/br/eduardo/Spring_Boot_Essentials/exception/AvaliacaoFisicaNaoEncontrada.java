package com.br.eduardo.Spring_Boot_Essentials.exception;

public class AvaliacaoFisicaNaoEncontrada extends RuntimeException{
    public AvaliacaoFisicaNaoEncontrada(String Mensagem){
        super(Mensagem);
    }
}
