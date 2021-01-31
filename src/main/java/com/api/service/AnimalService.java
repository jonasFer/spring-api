package com.api.service;

import com.api.domain.model.pet.Animal;

import java.util.List;

public interface AnimalService {
    Animal byId(Long id);
    List<Animal> all();
    Animal create(Animal animal);
    Animal update(Long id, Animal animal);
    void delete(Long id);
    long allRegisters();
}
