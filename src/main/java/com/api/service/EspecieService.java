package com.api.service;

import com.api.domain.model.pet.Especie;

import java.util.List;

public interface EspecieService {
    Especie findById(Long id);
    List<Especie> all();
    Especie save(Especie especie);
    Especie update(Long id, Especie especie);
    void delete(Long id);
}
