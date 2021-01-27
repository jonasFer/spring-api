package com.api.service;

import com.api.domain.model.pet.Raca;

import java.util.List;

public interface RacaService {
    Raca byId(Long id);
    List<Raca> allByEspecie(Long especie);
    List<Raca> all();
    Raca create(Raca racaDto);
    Raca update(Long id, Raca racaDto);
    void delete(Long id);
}
