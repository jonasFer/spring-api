package com.api.service;

import com.api.domain.model.common.Pessoa;

public interface PessoaService {
    Pessoa findById(Long id);
}
