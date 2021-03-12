package com.api.service.impl.pet;

import com.api.domain.model.pet.Animal;
import com.api.domain.repository.pet.AnimalRepository;
import com.api.exception.NotFoundException;
import com.api.service.AnimalService;
import com.api.service.impl.BaseServiceImpl;
import com.api.util.constants.ErrorContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.lang.String.format;

import java.util.List;

@Service
public class AnimalServiceImpl extends BaseServiceImpl implements AnimalService {

    private final String NAME_OBJECT = "Animal";

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Animal byId(Long id) {
        return animalRepository
                .findByIdAndEmpresa(id, this.getEmpresaLogada())
                .orElseThrow(() -> new NotFoundException(format(ErrorContants.ERROR_REGISTER_NOT_FOUND, this.NAME_OBJECT)));
    }

    @Override
    public List<Animal> all() {
        return animalRepository.findByEmpresa(this.getEmpresaLogada());

    }

    @Override
    public List<Animal> allByPessoa(Long idPessoa) {
        return animalRepository.findByEmpresaAndPessoa(this.getEmpresaLogada(), idPessoa);

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
                .orElseThrow(() -> new NotFoundException(format(ErrorContants.ERROR_REGISTER_NOT_FOUND, this.NAME_OBJECT)));
    }

    @Override
    public void delete(Long id) {
        this.animalRepository
                .findByIdAndEmpresa(id, this.getEmpresaLogada())
                .map(animal -> {
                    animalRepository.delete(animal);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new NotFoundException(format(ErrorContants.ERROR_REGISTER_NOT_FOUND, this.NAME_OBJECT)));
    }

    @Override
    public long allRegisters() {
        return 10l;
    }
}
