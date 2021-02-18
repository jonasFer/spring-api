package com.api.domain.repository.comon;

import com.api.domain.model.common.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Estado findBySigla(String estado);
}
