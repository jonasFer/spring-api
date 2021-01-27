package com.api.domain.repository.pet;

import com.api.domain.model.common.Empresa;
import com.api.domain.model.pet.Especie;
import com.api.domain.model.pet.Pelagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PelagemRepository extends JpaRepository<Pelagem, Long> {
    Optional<Pelagem> findByIdAndEmpresa(Long id, Empresa empresa);
    List<Pelagem> findByEmpresa(Empresa empresa);
}
