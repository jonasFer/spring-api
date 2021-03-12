package com.api.service.impl.item;

import com.api.domain.model.item.Marca;
import com.api.domain.repository.item.MarcaRepository;
import com.api.exception.NotFoundException;
import com.api.service.MarcaService;
import com.api.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MarcaServiceImpl extends BaseServiceImpl implements MarcaService {
    @Autowired
    private MarcaRepository repository;

    @Override
    public Page<Marca> findAll(String nome, Pageable pageable) {
        if (!nome.isEmpty()) {
            return repository.findByLikeNomeAndEmpresa(nome, this.getEmpresaLogada(), pageable);
        }

        return repository.findByEmpresa(this.getEmpresaLogada(), pageable);
    }

    @Override
    public Marca findbyId(Long id) {
        return repository.findByIdAndEmpresa(id, getEmpresaLogada())
                .orElseThrow(() -> new NotFoundException("Marca não encontrada."));
    }

    @Override
    public Marca update(Long id, Marca marca) {
        Marca marcaBanco = findbyId(id);
        marcaBanco.setNome(marca.getNome());
        hasMarcaMesmoNome(marca.getNome());

        return repository.save(marcaBanco);
    }

    @Override
    public Marca save(Marca marca) {
        hasMarcaMesmoNome(marca.getNome());
        marca.setId(null);
        marca.setEmpresa(getEmpresaLogada());

        return repository.save(marca);
    }

    @Override
    public void delete(Long id) {
        Marca marca = findbyId(id);
        repository.delete(marca);
    }

    private void hasMarcaMesmoNome(String nome)
    {
        if(repository.findByNomeAndEmpresa(nome, getEmpresaLogada()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca com mesmo nome já cadastrada.");
        }
    }
}
