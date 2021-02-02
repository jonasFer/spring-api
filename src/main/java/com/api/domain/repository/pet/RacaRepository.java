package com.api.domain.repository.pet;

import com.api.domain.model.common.Empresa;
import com.api.domain.model.pet.Especie;
import com.api.domain.model.pet.Raca;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long> {
    @Query("select r from Raca r join fetch r.especie e where r.id = :id and e.empresa = :empresa")
    Optional<Raca> findRacaByIdAndEmpresa(@Param("id") Long id, @Param("empresa")Empresa empresa);

    @Query("select r from Raca r join fetch r.especie e where e.empresa = :empresa")
    List<Raca> findRacaByEmpresa(@Param("empresa") Empresa empresa, Pageable pageable);

    List<Raca> findByEspecie(Especie especie);

    long countByEspecieEmpresa(Empresa empresa);
}
