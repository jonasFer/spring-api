package com.api.domain.model.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    private Produto produto;

    private BigDecimal estoqueAtual;
}
