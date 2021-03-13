package com.api.domain.model.item;

import com.api.domain.model.common.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="id_empresa", nullable = false)
    private Empresa empresa;

    @Column(nullable = false)
    private Integer tipoProduto;

    @Column(nullable = true)
    private Long gtin;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name ="id_grupo_produto", nullable = true)
    private GrupoProduto grupoProduto;

    private String unidadeVenda;

    @ManyToOne
    @JoinColumn(name ="id_marca", nullable = true)
    private Marca marca;

    private BigDecimal valorCusto;

    private BigDecimal valorVenda;

    @Column(nullable = false)
    private Boolean status;
}
