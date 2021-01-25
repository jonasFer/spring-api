package com.api.rest.controller.auth;

import com.api.config.security.AuthServiceImpl;
import com.api.rest.dto.TokenDto;
import com.api.rest.dto.UsuarioLoginDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Auth")
@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthServiceImpl authService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public TokenDto auth(@RequestBody UsuarioLoginDto loginDto) {
        return authService.autenticar(loginDto);
    }
}
