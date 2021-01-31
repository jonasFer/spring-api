package com.api.application.builder.model.pet;

import com.api.domain.model.pet.Especie;
import com.api.rest.dto.pet.EspecieDto;
import org.springframework.stereotype.Service;

@Service
public class EspecieBuilder {
    public Especie builEntityFromDto(EspecieDto dto) {
        Especie especie = new Especie();
        especie.setNome(dto.getNome());

        return especie;
    }

    public EspecieDto buildDtoFromEntity(Especie especie) {
        EspecieDto dto = new EspecieDto();
        dto.setId(especie.getId());
        dto.setNome(especie.getNome());

        return dto;
    }
}
