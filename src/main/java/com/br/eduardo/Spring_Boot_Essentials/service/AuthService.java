package com.br.eduardo.Spring_Boot_Essentials.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.eduardo.Spring_Boot_Essentials.database.model.UsuarioEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IUsuarioRepository;
import com.br.eduardo.Spring_Boot_Essentials.dto.CadastroDto;
import com.br.eduardo.Spring_Boot_Essentials.exception.EmailExistenteException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public void cadastrar(CadastroDto cadastroDto){
        if(usuarioRepository.existsByEmail(cadastroDto.getEmail())){
            throw new EmailExistenteException("E-mail já cadastrado!");
        }

        UsuarioEntity usuario = UsuarioEntity.builder()
                        .nome(cadastroDto.getNome())
                        .email(cadastroDto.getEmail())
                        .senha(passwordEncoder.encode(cadastroDto.getSenha()))
                        .build();

        usuarioRepository.save(usuario);
    }
}