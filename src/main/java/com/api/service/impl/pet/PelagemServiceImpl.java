package com.api.service.impl.pet;

import com.api.domain.model.pet.Pelagem;
import com.api.domain.repository.pet.PelagemRepository;
import com.api.service.PelagemService;
import com.api.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PelagemServiceImpl extends BaseServiceImpl implements PelagemService {

    @Autowired
    private PelagemRepository repository;

    @Override
    public Pelagem findById(Long id) {
        return repository.findByIdAndEmpresa(id, this.getEmpresaLogada())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelagem não encontrada"));
    }

    @Override
    public List<Pelagem> all() {
        return repository.findByEmpresa(this.getEmpresaLogada());
    }

    @Override
    public Pelagem save(Pelagem pelagem) {
        pelagem.setEmpresa(this.getEmpresaLogada());
        return repository.save(pelagem);
    }

    @Override
    public Pelagem update(Long id, Pelagem pelagem) {
        return repository
                .findByIdAndEmpresa(id, this.getEmpresaLogada())
                .map(pelagemBanco -> {
                    pelagemBanco.setNome(pelagem.getNome());

                    return repository.save(pelagemBanco);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelagem não encontrada"));
    }

    @Override
    public void delete(Long id) {
        repository
                .findByIdAndEmpresa(id, this.getEmpresaLogada())
                .map(pelagem -> {
                    repository.delete(pelagem);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelagem não encontrada"));
    }

    @Override
    public long countRegisters() {
        return repository.countByEmpresa(this.getEmpresaLogada());
    }
}
