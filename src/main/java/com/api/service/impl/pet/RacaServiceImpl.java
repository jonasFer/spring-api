package com.api.service.impl.pet;

import com.api.domain.model.pet.Raca;
import com.api.domain.repository.pet.RacaRepository;
import com.api.service.EspecieService;
import com.api.service.RacaService;
import com.api.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RacaServiceImpl extends BaseServiceImpl implements RacaService {

    @Autowired
    private RacaRepository racaRepository;
    @Autowired
    private EspecieService especieService;

    @Override
    public Raca byId(Long id) {
        return racaRepository.findRacaByIdAndEmpresa(id, this.getEmpresaLogada())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Raça não encontrada"));
    }

    @Override
    public List<Raca> allByEspecie(Long especie) {
        return racaRepository.findByEspecie(especieService.findById(especie));
    }

    @Override
    public List<Raca> all(Pageable pageable) {
        return racaRepository.findRacaByEmpresa(this.getEmpresaLogada(), pageable);
    }

    @Override
    public Raca create(Raca raca) {
        return racaRepository.save(raca);
    }

    @Override
    public Raca update(Long id, Raca raca) {
        return racaRepository
                .findRacaByIdAndEmpresa(id, this.getEmpresaLogada())
                .map(racaBanco -> {
                    racaBanco.setNome(raca.getNome());
                    racaBanco.setEspecie(raca.getEspecie());

                    return racaRepository.save(racaBanco);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Raça não encontrada"));
    }

    @Override
    public void delete(Long id) {
        racaRepository
                .findRacaByIdAndEmpresa(id, this.getEmpresaLogada())
                .map(raca -> {
                    racaRepository.delete(raca);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Raça não encontrada"));
    }

    @Override
    public long allRegisters() {
        return racaRepository.countByEspecieEmpresa(this.getEmpresaLogada());
    }
}
