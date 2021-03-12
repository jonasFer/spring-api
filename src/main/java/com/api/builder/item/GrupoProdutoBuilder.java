package com.api.builder.item;

import com.api.domain.model.item.GrupoProduto;
import com.api.rest.dto.item.GrupoProdutoDto;
import com.api.service.GrupoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GrupoProdutoBuilder {

    @Autowired
    private GrupoProdutoService grupoProdutoService;

    public GrupoProdutoDto buildDtoFromEntity(GrupoProduto grupoProduto) {
        return GrupoProdutoDto
                .builder()
                .id(grupoProduto.getId())
                .nome(grupoProduto.getNome())
                .status(grupoProduto.getStatus())
                .idGrupoPai(grupoProduto.getGrupoPai() != null ? grupoProduto.getGrupoPai().getId() : null)
                .subGrupos(
                        grupoProdutoService.findSubGrupos(grupoProduto)
                                .stream()
                                .map(grupo -> { return buildDtoFromEntity(grupo); })
                                .collect(Collectors.toList())
                )
                .build();
    }

    public GrupoProduto buildEntityFromDto(GrupoProdutoDto dto) {
        return GrupoProduto
                .builder()
                .nome(dto.getNome())
                .status(dto.getStatus())
                .grupoPai(grupoProdutoService.findbyId(dto.getIdGrupoPai()))
                .build();
    }
}
