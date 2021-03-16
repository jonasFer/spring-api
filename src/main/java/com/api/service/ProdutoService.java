package com.api.service;

import com.api.domain.model.item.Produto;
import com.api.rest.dto.item.ProdutoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {
    Page<Produto> findAll(Pageable pageable);
    Produto findbyId(Long id);
    ProdutoDto create(ProdutoDto produtoDto);
    ProdutoDto edit(Long id, ProdutoDto produtoDto);
    Produto save(Produto produto);
    void delete(Long id);
}
