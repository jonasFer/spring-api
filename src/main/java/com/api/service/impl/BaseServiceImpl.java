package com.api.service.impl;

import com.api.domain.model.common.Empresa;
import com.api.domain.repository.UsuarioRepository;
import com.api.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public Empresa getEmpresaLogada() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return repository
                .findByEmail(auth.getName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Espécie não encontrada"))
                .getPessoa().getEmpresa();
    }
}
