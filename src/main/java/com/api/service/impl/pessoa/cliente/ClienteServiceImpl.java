package com.api.service.impl.pessoa.cliente;

import com.api.domain.model.Cliente;
import com.api.domain.repository.pessoa.ClienteRepository;
import com.api.service.ClienteService;
import com.api.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findByEmpresa(this.getEmpresaLogada());
    }
}
