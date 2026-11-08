package com.br.eduardo.Spring_Boot_Essentials.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.eduardo.Spring_Boot_Essentials.database.model.UsuarioEntity;
import com.br.eduardo.Spring_Boot_Essentials.database.repository.IUsuarioRepository;
import com.br.eduardo.Spring_Boot_Essentials.dto.CadastroDto;
import com.br.eduardo.Spring_Boot_Essentials.dto.LoginDto;
import com.br.eduardo.Spring_Boot_Essentials.dto.TokenDto;
import com.br.eduardo.Spring_Boot_Essentials.exception.CredenciaisInvalidasException;
import com.br.eduardo.Spring_Boot_Essentials.exception.EmailExistenteException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

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

    @Transactional(readOnly = true)
    public TokenDto login(LoginDto loginDto){
        UsuarioEntity usuario = usuarioRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new CredenciaisInvalidasException("E-mail não cadastrado!"));

        if(!passwordEncoder.matches(loginDto.getSenha(), usuario.getSenha())){
            throw new CredenciaisInvalidasException("Senha inválida!");
        }

        return new TokenDto(jwtService.gerarToken(usuario.getEmail()));
    }
}