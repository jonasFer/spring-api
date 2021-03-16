package com.api.domain.repository.item;

import com.api.domain.model.common.Empresa;
import com.api.domain.model.item.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findAllByEmpresa(Empresa empresa, Pageable pageable);

    Optional<Produto> findByIdAndEmpresa(Long id, Empresa empresa);
}
