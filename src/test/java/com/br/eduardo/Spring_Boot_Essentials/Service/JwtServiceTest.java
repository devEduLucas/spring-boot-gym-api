package com.br.eduardo.Spring_Boot_Essentials.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.JwtException;

class JwtServiceTest {
    private static final String SEGREDO = "um-segredo-de-teste-com-mais-de-32-caracteres";

    @Test
    void deveGerarTokenEExtrairOMesmoEmail(){
        JwtService jwtService = new JwtService(SEGREDO, 60000);

        String token = jwtService.gerarToken("aluno@email.com");

        assertEquals("aluno@email.com", jwtService.extrairEmail(token));
    }

    @Test
    void deveRejeitarTokenExpirado(){
        JwtService jwtService = new JwtService(SEGREDO, -1000);

        String token = jwtService.gerarToken("aluno@email.com");

        assertThrows(JwtException.class, () -> jwtService.extrairEmail(token));
    }

    @Test
    void deveRejeitarTokenAssinadoComOutroSegredo(){
        JwtService emissor = new JwtService("outro-segredo-totalmente-diferente-123456", 60000);
        JwtService validador = new JwtService(SEGREDO, 60000);

        String tokenFalso = emissor.gerarToken("aluno@email.com");

        assertThrows(JwtException.class, () -> validador.extrairEmail(tokenFalso));
    }
}