package com.br.eduardo.Spring_Boot_Essentials.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.br.eduardo.Spring_Boot_Essentials.exception.ConflitoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.RecursoNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.RegraNegocioException;

@RestControllerAdvice
public class ErrorGlobal {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<String> recursoNaoEncontrado(RecursoNaoEncontradoException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    // EmailExistenteException, AlunoComAvaliacaoFisica
    @ExceptionHandler(ConflitoException.class)
    public ResponseEntity<String> conflito(ConflitoException exception){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }

    // PesoImproprioException, AlturaImpropriaException, PercentualGorduraImproprio, DataNascimentoException
    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<String> regraNegocio(RegraNegocioException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }
}
