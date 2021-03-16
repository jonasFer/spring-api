package com.api.builder.item;

import com.api.domain.model.item.Produto;
import com.api.rest.dto.item.ProdutoDto;
import com.api.service.GrupoProdutoService;
import com.api.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoBuilder {
    @Autowired
    private MarcaService marcaService;

    @Autowired
    private GrupoProdutoService grupoProdutoService;

    @Autowired
    private GrupoProdutoBuilder grupoProdutoBuilder;

    public ProdutoDto buildDtoFromEntity(Produto produto) {
        return ProdutoDto
                .builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .idTipoProduto(produto.getTipoProduto())
                .gtin(produto.getGtin())
                .idGrupoProduto(produto.getGrupoProduto() != null ? produto.getGrupoProduto().getId() : null)
                .idMarca(produto.getMarca() != null ? produto.getMarca().getId() : null)
                .marca(produto.getMarca())
                .grupoProduto(produto.getGrupoProduto() != null ? grupoProdutoBuilder.buildDtoFromEntity(produto.getGrupoProduto()) : null)
                .unidadeVenda(produto.getUnidadeVenda())
                .valorCusto(produto.getValorCusto())
                .valorVenda(produto.getValorVenda())
                .controlaEstoque(produto.getControlaEstoque())
                .quantidadeMaxima(produto.getQuantidadeMaxima())
                .quantidadeMinima(produto.getQuantidadeMinima())
                .status(produto.getStatus())
                .build();
    }

    public Produto buildEntityFromDto(ProdutoDto dto) {
        return Produto
                .builder()
                .nome(dto.getNome())
                .gtin(dto.getGtin())
                .tipoProduto(dto.getIdTipoProduto())
                .marca(dto.getIdMarca() != null ? marcaService.findbyId(dto.getIdMarca()) : null)
                .grupoProduto(dto.getIdGrupoProduto() != null ? grupoProdutoService.findbyId(dto.getIdGrupoProduto()) : null)
                .unidadeVenda(dto.getUnidadeVenda())
                .valorCusto(dto.getValorCusto())
                .valorVenda(dto.getValorVenda())
                .status(dto.getStatus())
                .controlaEstoque(dto.getControlaEstoque())
                .quantidadeMaxima(dto.getQuantidadeMaxima())
                .quantidadeMinima(dto.getQuantidadeMinima())
                .build();
    }
}
