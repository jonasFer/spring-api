package com.api.domain.repository.pessoa;

import com.api.domain.model.Cliente;
import com.api.domain.model.common.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("select c from Cliente c join fetch c.pessoa p where p.empresa = :empresa")
    List<Cliente> findByEmpresa(@Param("empresa") Empresa empresa);
}
