package com.api.domain.model.item;

import com.api.domain.model.common.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrupoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="id_empresa", nullable = false)
    private Empresa empresa;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_grupo_pai", nullable = true)
    private GrupoProduto grupoPai;

    private Boolean status;
}
