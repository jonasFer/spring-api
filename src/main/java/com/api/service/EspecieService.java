package com.api.service;

import com.api.domain.model.pet.Especie;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EspecieService {
    Especie findById(Long id);
    List<Especie> all(String nome, Pageable pageable);
    Especie save(Especie especie);
    Especie update(Long id, Especie especie);
    void delete(Long id);
    long allRegisters(String nome);
}
