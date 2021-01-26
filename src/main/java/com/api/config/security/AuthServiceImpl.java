package com.api.config.security;

import com.api.domain.model.auth.Usuario;
import com.api.domain.repository.UsuarioRepository;
import com.api.rest.dto.TokenDto;
import com.api.rest.dto.UsuarioDto;
import com.api.rest.dto.UsuarioLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtService jwtService;

    public TokenDto autenticar(UsuarioLoginDto loginDto) {
        try {
            Usuario usuario = new Usuario();
            usuario.setEmail(loginDto.getEmail());
            usuario.setPassword(loginDto.getSenha());
            Usuario user = this.validar(usuario);

            return new TokenDto(jwtService.gerarToken(user), new UsuarioDto(user));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    private Usuario validar(Usuario usuario) throws Exception {
        Usuario user = loadUserByUsername(usuario.getEmail());
        boolean hasEqualsPasswords = encoder.matches(usuario.getPassword(), user.getPassword());

        if (hasEqualsPasswords) {
            return user;
        }

        throw new Exception("Senha inválida");
    }

    public Usuario loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados."));

        return usuario;
    }
}