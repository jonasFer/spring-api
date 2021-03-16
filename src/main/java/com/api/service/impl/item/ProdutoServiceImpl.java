package com.api.service.impl.item;

import com.api.builder.item.ProdutoBuilder;
import com.api.domain.model.item.Produto;
import com.api.domain.repository.item.ProdutoRepository;
import com.api.exception.NotFoundException;
import com.api.rest.dto.item.ProdutoDto;
import com.api.service.ProdutoService;
import com.api.service.impl.BaseServiceImpl;
import com.api.util.constants.ErrorContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class ProdutoServiceImpl extends BaseServiceImpl implements ProdutoService {

    private final String NAME_OBJECT = "Produto";

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoBuilder builder;

    @Override
    public Page<Produto> findAll(Pageable pageable) {
        return repository.findAllByEmpresa(getEmpresaLogada(), pageable);
    }

    @Override
    public Produto findbyId(Long id) {
        return repository
                .findByIdAndEmpresa(id, getEmpresaLogada())
                .orElseThrow(() ->
                    new NotFoundException(format(ErrorContants.ERROR_REGISTER_NOT_FOUND, this.NAME_OBJECT))
                );
    }

    @Override
    public void delete(Long id) {
        Produto produto = findbyId(id);
        // adicionar validações
        repository.delete(produto);
    }

    @Override
    public ProdutoDto create(ProdutoDto dto) {
        Produto produto = builder.buildEntityFromDto(dto);
        produto.setEmpresa(getEmpresaLogada());

        return builder.buildDtoFromEntity(save(produto));
    }

    @Override
    public ProdutoDto edit(Long id, ProdutoDto dto) {
        return repository
                .findByIdAndEmpresa(id, getEmpresaLogada())
                .map(produtoBanco -> {
                    Produto produto = builder.buildEntityFromDto(dto);
                    produto.setId(produtoBanco.getId());
                    produto.setEmpresa(getEmpresaLogada());
                    return builder.buildDtoFromEntity(save(produto));
                })
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorContants.ERROR_REGISTER_NOT_FOUND, this.NAME_OBJECT))
                );
    }

    @Override
    public Produto save(Produto produto) {
        // adicionar validações
        return repository.save(produto);
    }
}
