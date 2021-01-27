package com.api.builder.model.pet;

import com.api.domain.model.pet.Pelagem;
import com.api.rest.dto.pet.PelagemDto;
import org.springframework.stereotype.Service;

@Service
public class PelagemBuilder {
    public Pelagem builEntityFromDto(PelagemDto dto) {
        Pelagem pelagem = new Pelagem();
        pelagem.setNome(dto.getNome());

        return pelagem;
    }

    public PelagemDto buildDtoFromEntity(Pelagem pelagem) {
        PelagemDto dto = new PelagemDto();
        dto.setId(pelagem.getId());
        dto.setNome(pelagem.getNome());

        return dto;
    }
}
