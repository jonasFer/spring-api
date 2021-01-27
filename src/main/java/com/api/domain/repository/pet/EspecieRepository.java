package com.api.domain.repository.pet;

import com.api.domain.model.common.Empresa;
import com.api.domain.model.pet.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {
    Optional<Especie> findByIdAndEmpresa(Long id, Empresa empresa);
    List<Especie> findByEmpresa(Empresa empresa);
}
