package com.api.builder.pet;

import com.api.domain.model.pet.Pelagem;
import com.api.rest.dto.pet.PelagemDto;
import org.springframework.stereotype.Service;

@Service
public class PelagemBuilder {
    public Pelagem builEntityFromDto(PelagemDto dto) {
        return Pelagem
                .builder()
                .nome(dto.getNome())
                .build();
    }

    public PelagemDto buildDtoFromEntity(Pelagem pelagem) {
        return PelagemDto
                .builder()
                .id(pelagem.getId())
                .nome(pelagem.getNome())
                .build();
    }
}
