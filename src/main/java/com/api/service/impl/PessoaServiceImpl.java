package com.api.service.impl;

import com.api.domain.model.common.Pessoa;
import com.api.domain.repository.PessoaRepository;
import com.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PessoaServiceImpl extends BaseServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository repository;

    @Override
    public Pessoa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
    }
}
