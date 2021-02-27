package com.api.domain.repository.pessoa;

import com.api.domain.model.Cliente;
import com.api.domain.model.common.Empresa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("select c from Cliente c join fetch c.pessoa p where p.empresa = :empresa")
    List<Cliente> findByEmpresa(@Param("empresa") Empresa empresa, Pageable pageable);

    @Query("select c from Cliente c join fetch c.pessoa p where p.empresa = :empresa and p.nome = :nome")
    List<Cliente> findByNomeAndEmpresa(@Param("empresa") Empresa empresa, @Param("nome") String nome, Pageable pageable);

    @Query("select c from Cliente c join fetch c.pessoa p join fetch c.animais a where p.empresa = :empresa and a.nome = :animal")
    List<Cliente> findByAnimal(@Param("empresa") Empresa empresa, @Param("animal") String animal, Pageable pageable);
}
