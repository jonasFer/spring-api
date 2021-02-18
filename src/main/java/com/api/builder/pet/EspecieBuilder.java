package com.api.builder.pet;

import com.api.domain.model.pet.Especie;
import com.api.rest.dto.pet.EspecieDto;
import org.springframework.stereotype.Service;

@Service
public class EspecieBuilder {
    public Especie builEntityFromDto(EspecieDto dto) {
        return Especie
                .builder()
                .nome(dto.getNome())
                .build();

    }

    public EspecieDto buildDtoFromEntity(Especie especie) {
        return EspecieDto
                .builder()
                .id(especie.getId())
                .nome(especie.getNome())
                .build();
    }
}
