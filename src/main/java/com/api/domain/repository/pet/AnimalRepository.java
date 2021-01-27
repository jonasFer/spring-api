package com.api.domain.repository.pet;

import com.api.domain.model.common.Empresa;
import com.api.domain.model.pet.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Query("select a from Animal a join fetch a.pessoa p where a.id = :id and p.empresa = :empresa")
    Optional<Animal> findByIdAndEmpresa(@Param("id") Long id, @Param("empresa") Empresa empresa);

    @Query("select a from Animal a join fetch a.pessoa p where p.empresa = :empresa")
    List<Animal> findByEmpresa(@Param("empresa") Empresa empresa);
}
