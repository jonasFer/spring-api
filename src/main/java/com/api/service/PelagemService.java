package com.api.service;

import com.api.domain.model.pet.Pelagem;

import java.util.List;

public interface PelagemService {
    Pelagem findById(Long id);
    List<Pelagem> all();
    Pelagem save(Pelagem pelagem);
    Pelagem update(Long id, Pelagem pelagem);
    void delete(Long id);
}
