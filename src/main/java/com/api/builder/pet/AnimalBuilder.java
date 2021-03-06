package com.api.builder.pet;

import com.api.domain.model.pet.Animal;
import com.api.rest.dto.pet.AnimalDto;
import com.api.service.*;
import com.api.util.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class AnimalBuilder {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EspecieService especieService;
    @Autowired
    private RacaService racaService;
    @Autowired
    private PelagemService pelagemService;

    public AnimalDto buildDtoFromEntity(Animal animal) throws ParseException {
        return AnimalDto
                .builder()
                .id(animal.getId())
                .cliente(animal.getCliente().getId())
                .nome(animal.getNome())
                .sexo(animal.getSexo())
                .dataNascimento(DataConverter.convertDateToString(animal.getDataNascimento()))
                .especie(animal.getEspecie().getId())
                .raca(animal.getRaca().getId())
                .pelagem(animal.getPelagem().getId())
                .build();
    }

    public Animal buidEntityFromDto(AnimalDto dto) throws ParseException {
        return Animal
                .builder()
                .nome(dto.getNome())
                .cliente(clienteService.findById(dto.getCliente()))
                .sexo(dto.getSexo())
                .dataNascimento(DataConverter.convertStringToDate(dto.getDataNascimento()))
                .especie(especieService.findById(dto.getEspecie()))
                .raca(racaService.byId(dto.getRaca()))
                .pelagem(dto.getPelagem() != null ? pelagemService.findById(dto.getPelagem()) : null)
                .build();
    }

    public AnimalDto buildLiteDtoFromEntity(Animal animal) {
        return AnimalDto
                .builder()
                .id(animal.getId())
                .nome(animal.getNome())
                .build();
    }
}
