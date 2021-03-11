package com.api.service;

import com.api.domain.model.item.Marca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MarcaService {
    Page<Marca> findAll(String nome, Pageable pageable);
    Marca findbyId(Long id);
    Marca update(Long id, Marca marca);
    Marca save(Marca marca);
    void delete(Long id);
}
