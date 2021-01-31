package com.api.domain.repository.pet;

import com.api.domain.model.common.Empresa;
import com.api.domain.model.pet.Especie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {
    Optional<Especie> findByIdAndEmpresa(Long id, Empresa empresa);
    List<Especie> findByEmpresa(Empresa empresa, Pageable pageable);
    @Query("SELECT COUNT(e) FROM Especie e WHERE e.empresa=?1")
    long countFromEmpresa(Empresa empresa);
}
