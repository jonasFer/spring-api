package com.api.service;

import com.api.domain.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente save(Cliente cliente);
    Cliente findById(Long id);
    List<Cliente> findAll();
}
