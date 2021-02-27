package com.api.service;

import com.api.domain.model.Cliente;
import com.api.domain.request.ClienteParam;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {
    Cliente save(Cliente cliente);
    Cliente findById(Long id);
    List<Cliente> findAll(ClienteParam param, Pageable pageable);
}
