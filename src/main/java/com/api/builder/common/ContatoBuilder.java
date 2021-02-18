package com.api.builder.common;

import com.api.domain.model.common.Contato;
import com.api.rest.dto.common.ContatoDto;
import org.springframework.stereotype.Service;

@Service
public class ContatoBuilder {
    public Contato builEntityFromDto(ContatoDto dto) {
        return Contato
                .builder()
                .valor(dto.getValor())
                .observacao(dto.getObservacao())
                .build();
    }

    public ContatoDto buildDtoFromEntity(Contato contato) {
        return ContatoDto
                .builder()
                .id(contato.getId())
                .tipoContato(contato.getTipoContato().getId())
                .valor(contato.getValor())
                .observacao(contato.getObservacao())
                .build();
    }
}
