package com.api.builder.model.pet;

import com.api.domain.model.pet.Animal;
import com.api.rest.dto.pet.AnimalDto;
import com.api.service.EspecieService;
import com.api.service.PelagemService;
import com.api.service.PessoaService;
import com.api.service.RacaService;
import com.api.util.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class AnimalBuilder {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EspecieService especieService;
    @Autowired
    private RacaService racaService;
    @Autowired
    private PelagemService pelagemService;

    public AnimalDto buildDtoFromEntity(Animal animal) throws ParseException {
        AnimalDto dto = new AnimalDto();
        dto.setId(animal.getId());
        System.out.println("Pessoa: " + animal.getPessoa().getId() + "  Akiiiiiiiiiii");
        dto.setPessoa(animal.getPessoa().getId());
        dto.setNome(animal.getNome());
        dto.setSexo(animal.getSexo());
        dto.setDataNascimento(DataConverter.convertDateToString(animal.getDataNascimento()));
        dto.setRaca(animal.getRaca().getId());
        dto.setEspecie(animal.getEspecie().getId());
        dto.setPelagem(animal.getPelagem().getId());

        return dto;
    }

    public Animal buidEntityFromDto(AnimalDto dto) throws ParseException {
        Animal animal = new Animal();
        animal.setNome(dto.getNome());
        animal.setPessoa(pessoaService.findById(dto.getPessoa()));
        animal.setSexo(dto.getSexo());
        animal.setDataNascimento(DataConverter.convertStringToDate(dto.getDataNascimento()));
        animal.setEspecie(especieService.findById(dto.getEspecie()));
        animal.setRaca(racaService.byId(dto.getRaca()));
        animal.setPelagem(dto.getPelagem() != null ? pelagemService.findById(dto.getPelagem()) : null);

        return animal;
    }
}
