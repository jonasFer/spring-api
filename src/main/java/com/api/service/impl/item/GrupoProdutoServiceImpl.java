package com.api.service.impl.item;

import com.api.domain.model.item.GrupoProduto;
import com.api.domain.repository.item.GrupoProdutoRepository;
import com.api.exception.DomainException;
import com.api.exception.NotFoundException;
import com.api.service.GrupoProdutoService;
import com.api.service.impl.BaseServiceImpl;
import com.api.util.constants.ErrorContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class GrupoProdutoServiceImpl extends BaseServiceImpl implements GrupoProdutoService {

    private final String NAME_OBJECT = "Grupo de produto";

    @Autowired
    private GrupoProdutoRepository repository;

    @Override
    public Page<GrupoProduto> findAll(String nome, Pageable pageable) {
        if (!nome.isEmpty()) {
            return repository.findByLikeNomeAndEmpresa(nome, getEmpresaLogada(), pageable);
        }

        return repository.findByEmpresa(getEmpresaLogada(), pageable);
    }

    @Override
    public GrupoProduto findbyId(Long id) {
        return repository
                .findByIdAndEmpresa(id, getEmpresaLogada())
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorContants.ERROR_REGISTER_NOT_FOUND, this.NAME_OBJECT))
                );
    }

    @Override
    public GrupoProduto update(Long id, GrupoProduto grupoProduto) {
        return repository
                .findByIdAndEmpresa(id, getEmpresaLogada())
                .map(grupo -> {
                    grupo.setNome(grupoProduto.getNome());
                    grupo.setGrupoPai(grupoProduto.getGrupoPai());
                    grupo.setStatus(grupoProduto.getStatus());

                    save(grupo);
                    return grupo;
                })
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorContants.ERROR_REGISTER_NOT_FOUND, this.NAME_OBJECT))
                );
    }

    @Override
    public GrupoProduto save(GrupoProduto grupoProduto) {
        hasGrupoMesmoNome(grupoProduto.getNome());
        grupoProduto.setEmpresa(getEmpresaLogada());
        return repository.save(grupoProduto);
    }

    @Override
    public void delete(Long id) {
        repository
                .findByIdAndEmpresa(id, getEmpresaLogada())
                .map(grupo -> {
                    repository.delete(grupo);
                    return Void.TYPE;
                })
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorContants.ERROR_REGISTER_NOT_FOUND, this.NAME_OBJECT))
                );
    }

    @Override
    public List<GrupoProduto> findSubGrupos(GrupoProduto grupoProduto) {
        return repository.findByGrupoPaiAndEmpresa(grupoProduto, getEmpresaLogada());
    }

    private void hasGrupoMesmoNome(String nome)
    {
        if(repository.findByNomeAndEmpresa(nome, getEmpresaLogada()).isPresent()) {
            throw new DomainException(format(ErrorContants.ERROR_NAME_EXISTS, this.NAME_OBJECT));
        }
    }
}
