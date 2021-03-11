package com.api.domain.repository.item;

import com.api.domain.model.common.Empresa;
import com.api.domain.model.item.Marca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    Page<Marca> findByEmpresa(Empresa empresa, Pageable pageable);

    @Query(value = "SELECT m FROM Marca m WHERE lower(m.nome) LIKE concat('%', ?1, '%') and m.empresa = ?2")
    Page<Marca> findByLikeNomeAndEmpresa(String nome, Empresa empresa, Pageable pageable);

    Optional<Marca> findByIdAndEmpresa(Long id, Empresa empresa);

    @Query(value = "SELECT m FROM Marca m WHERE lower(m.nome) = lower (?1) and m.empresa = ?2")
    Optional<Marca> findByNomeAndEmpresa(String nome, Empresa empresa);
}
