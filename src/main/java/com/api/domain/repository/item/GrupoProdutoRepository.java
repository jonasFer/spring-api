package com.api.domain.repository.item;

import com.api.domain.model.common.Empresa;
import com.api.domain.model.item.GrupoProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrupoProdutoRepository extends JpaRepository<GrupoProduto, Long> {

    Optional<GrupoProduto> findByIdAndEmpresa(Long id, Empresa empresa);

    @Query("SELECT g FROM GrupoProduto g WHERE lower(g.nome) like lower(concat('%', ?1, '%')) and g.empresa = ?2  AND g.grupoPai is null")
    Page<GrupoProduto> findByLikeNomeAndEmpresa(String nome, Empresa empresa, Pageable pageable);

    @Query("SELECT g FROM GrupoProduto g WHERE g.empresa = ?1 AND g.grupoPai is null")
    Page<GrupoProduto> findByEmpresa(Empresa empresa, Pageable pageable);

    @Query("SELECT g FROM GrupoProduto g WHERE lower(g.nome) = lower(?1) and g.empresa = ?2")
    Optional<GrupoProduto> findByNomeAndEmpresa(String nome, Empresa empresa);

    List<GrupoProduto> findByGrupoPaiAndEmpresa(GrupoProduto grupoProduto, Empresa empresa);
}
