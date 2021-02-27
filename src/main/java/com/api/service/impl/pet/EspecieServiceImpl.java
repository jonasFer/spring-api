package com.api.service.impl.pet;

import com.api.domain.model.pet.Especie;
import com.api.domain.repository.pet.EspecieRepository;
import com.api.service.EspecieService;
import com.api.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EspecieServiceImpl extends BaseServiceImpl implements EspecieService {

    @Autowired
    private EspecieRepository repository;

    @Override
    public Especie findById(Long id) {
        return repository.findByIdAndEmpresa(id, this.getEmpresaLogada())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Espécie não encontrada"));
    }

    @Override
    public List<Especie> all(String nome, Pageable pageable) {
        if (!nome.isEmpty()) {
            return repository.findByNomeAndEmpresa(nome, this.getEmpresaLogada(), pageable);
        }

        return repository.findByEmpresa(this.getEmpresaLogada(), pageable);
    }

    @Override
    public Especie save(Especie especie) {
        especie.setEmpresa(this.getEmpresaLogada());
        return repository.save(especie);
    }

    @Override
    public Especie update(Long id, Especie especie) {
        return repository
                .findByIdAndEmpresa(id, this.getEmpresaLogada())
                .map(especieBanco -> {
                    especieBanco.setNome(especie.getNome());
                    return repository.save(especieBanco);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Espécie não encontrada"));
    }

    @Override
    public void delete(Long id) {
        repository
                .findByIdAndEmpresa(id, this.getEmpresaLogada())
                .map(especie -> {
                    repository.delete(especie);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Espécie não encontrada"));
    }

    @Override
    public long allRegisters(String nome) {
        if (!nome.isEmpty()) {
            return repository.countFromNomeAndEmpresa(nome, this.getEmpresaLogada());
        }
        return repository.countFromEmpresa(this.getEmpresaLogada());
    }
}
