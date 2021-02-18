package com.api.builder.common;

import com.api.domain.model.common.Endereco;
import com.api.domain.repository.comon.EstadoRepository;
import com.api.rest.dto.common.EnderecoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoBuilder {

    @Autowired
    private EstadoRepository estadoRepository;

    public Endereco builEntityFromDto(EnderecoDto dto) {
        return Endereco
                .builder()
                .logradouro(dto.getLogradouro())
                .numero(dto.getNumero())
                .cep(dto.getCep())
                .complemento(dto.getComplemento())
                .bairro(dto.getBairro())
                .municipio(dto.getMunicipio())
                .estado(estadoRepository.findById(dto.getEstado()).orElseThrow())
                .build();
    }

    public EnderecoDto buildDtoFromEntity(Endereco endereco) {
        return EnderecoDto
                .builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .cep(endereco.getCep())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .municipio(endereco.getMunicipio())
                .estado(endereco.getEstado().getId())
                .build();
    }
}
