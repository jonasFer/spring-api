package com.api.service;

import com.api.domain.model.pet.Pelagem;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PelagemService {
    Pelagem findById(Long id);
    List<Pelagem> all(Pageable pageable);
    Pelagem save(Pelagem pelagem);
    Pelagem update(Long id, Pelagem pelagem);
    void delete(Long id);
    long countRegisters();
}
