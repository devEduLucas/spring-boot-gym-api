package com.br.eduardo.Spring_Boot_Essentials.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.br.eduardo.Spring_Boot_Essentials.exception.AlturaImpropriaException;
import com.br.eduardo.Spring_Boot_Essentials.exception.AlunoComAvaliacaoFisica;
import com.br.eduardo.Spring_Boot_Essentials.exception.AlunoNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.AlunoTreinoNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.AvaliacaoFisicaNaoEncontrada;
import com.br.eduardo.Spring_Boot_Essentials.exception.DataNascimentoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.EmailExistenteException;
import com.br.eduardo.Spring_Boot_Essentials.exception.ExercicioNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.PercentualGorduraImproprio;
import com.br.eduardo.Spring_Boot_Essentials.exception.PesoImproprioException;
import com.br.eduardo.Spring_Boot_Essentials.exception.ProfessorNaoEncontradoException;
import com.br.eduardo.Spring_Boot_Essentials.exception.TreinoNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice

public class ErrorGlobal {
    
    @ExceptionHandler(EmailExistenteException.class)

    public ResponseEntity<String> errorEmailExistente(
                EmailExistenteException excpetion){
                    return ResponseEntity
                    .badRequest()
                    .body(excpetion.getMessage());
                }

    @ExceptionHandler(DataNascimentoException.class)
    public ResponseEntity<String> errorDataNascimentoData(
                DataNascimentoException exception ){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }

    @ExceptionHandler(AlunoNaoEncontradoException.class)
    public ResponseEntity<String> errorAlunoNaoEncontrado(
                AlunoNaoEncontradoException exception){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }

    @ExceptionHandler(ProfessorNaoEncontradoException.class)
    public ResponseEntity<String> errorProfessorNaoEncontrado(
                ProfessorNaoEncontradoException exception){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }

    @ExceptionHandler(PesoImproprioException.class)
    public ResponseEntity<String> errorPesoImproprio(
                PesoImproprioException exception){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }
    
    @ExceptionHandler(AlturaImpropriaException.class)
    public ResponseEntity<String> errorAlturaImpropria(
                AlturaImpropriaException exception){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }

    @ExceptionHandler(PercentualGorduraImproprio.class)
    public ResponseEntity<String> errorPercentualGorduraImproprio(
                PercentualGorduraImproprio exception){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }

    @ExceptionHandler(AvaliacaoFisicaNaoEncontrada.class)
    public ResponseEntity<String> errorAvaliacaoFisicaNaoEncontrada(
                AvaliacaoFisicaNaoEncontrada exception){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }

    @ExceptionHandler(ExercicioNaoEncontradoException.class)
    public ResponseEntity<String> errorExercicioNaoEncontrado(
                ExercicioNaoEncontradoException exception){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }

    @ExceptionHandler(TreinoNaoEncontradoException.class)
    public ResponseEntity<String> errorTreinoNaoEncontrado(
                TreinoNaoEncontradoException exception){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }

    @ExceptionHandler(AlunoTreinoNaoEncontradoException.class)
    public ResponseEntity<String> errorAlunoTreinoNaoEncontrado(
                AlunoTreinoNaoEncontradoException exception){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }

    @ExceptionHandler(AlunoComAvaliacaoFisica.class)
    public ResponseEntity<String> errorAlunoComAvaliacaoFisica(
                AlunoComAvaliacaoFisica exception){
                    return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
                }
}
