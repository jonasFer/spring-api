package com.api.service;

import com.api.domain.model.item.GrupoProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GrupoProdutoService {
    Page<GrupoProduto> findAll(String nome, Pageable pageable);
    GrupoProduto findbyId(Long id);
    GrupoProduto update(Long id, GrupoProduto grupoProduto);
    GrupoProduto save(GrupoProduto grupoProduto);
    void delete(Long id);
    List<GrupoProduto> findSubGrupos(GrupoProduto grupoProduto);
}
