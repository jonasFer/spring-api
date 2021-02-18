package com.api.builder.pet;

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
        return RacaDto
                .builder()
                .id(raca.getId())
                .especie(raca.getEspecie().getNome())
                .idEspecie(raca.getEspecie().getId())
                .nome(raca.getNome())
                .build();
    }

    public Raca builEntityFromDto(RacaDto dto) {
        return Raca
                .builder()
                .nome(dto.getNome())
                .especie(especieService.findById(dto.getIdEspecie()))
                .build();
    }
}
