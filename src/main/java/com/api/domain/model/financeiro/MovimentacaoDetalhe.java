package com.api.domain.model.financeiro;

import com.api.domain.model.item.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/*
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
 */
public class MovimentacaoDetalhe {
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn("id_movimentacao")
    private Movimentacao movimentacao;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = true)
    private Produto produto;

    @Column(columnDefinition = "default 0")
    private BigDecimal quantidade;
 */

}
