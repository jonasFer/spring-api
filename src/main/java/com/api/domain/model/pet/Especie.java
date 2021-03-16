package com.api.domain.model.pet;

import com.api.domain.model.common.Empresa;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="id_empresa", nullable = false)
    private Empresa empresa;
    private String nome;
}
