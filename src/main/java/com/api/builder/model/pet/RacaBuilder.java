package com.api.builder.model.pet;

import com.api.domain.model.pet.Raca;
import com.api.rest.dto.pet.RacaDto;
import com.api.service.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RacaBuilder {
    @Autowired
    private EspecieService especieService;

    public RacaDto buildDtoFromEntity(Raca raca) {
        RacaDto dto = new RacaDto();
        dto.setId(raca.getId());
        dto.setEspecie(raca.getEspecie().getId());
        dto.setNome(raca.getNome());

        return dto;
    }

    public Raca builEntityFromDto(RacaDto dto) {
        Raca raca = new Raca();
        raca.setNome(dto.getNome());
        raca.setEspecie(especieService.findById(dto.getEspecie()));

        return raca;
    }
}