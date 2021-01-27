package com.api.service.impl.pet;

import com.api.domain.model.pet.Animal;
import com.api.domain.repository.pet.AnimalRepository;
import com.api.service.AnimalService;
import com.api.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimalServiceImpl extends BaseServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Animal byId(Long id) {
        return animalRepository
                .findByIdAndEmpresa(id, this.getEmpresaLogada())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal não encontrado"));
    }

    @Override
    public List<Animal> all() {
        return animalRepository.findByEmpresa(this.getEmpresaLogada());

    }

    @Override
    public Animal create(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal update(Long id, Animal animal) {
        return animalRepository
                .findByIdAndEmpresa(id, this.getEmpresaLogada())
                .map(animalBanco -> {
                    animalBanco.setNome(animal.getNome());
                    animalBanco.setSexo(animal.getSexo());
                    animalBanco.setDataNascimento(animal.getDataNascimento());
                    animalBanco.setEspecie(animal.getEspecie());
                    animalBanco.setRaca(animal.getRaca());
                    animalBanco.setPelagem(animal.getPelagem());

                    return animalRepository.save(animalBanco);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal não encontrado"));
    }

    @Override
    public void delete(Long id) {
        this.animalRepository
                .findByIdAndEmpresa(id, this.getEmpresaLogada())
                .map(animal -> {
                    animalRepository.delete(animal);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal não encontrado"));
    }
}
