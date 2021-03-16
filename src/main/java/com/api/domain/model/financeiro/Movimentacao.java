package com.api.domain.model.financeiro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/*
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
 */
public class Movimentacao {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn("id_tipo_movimentacao")
    private TipoMovimentacao tipoMovimentacao;

    @Column(nullable = false, columnDefinition = "default 0")
    private BigDecimal valor;

    @OneToMany(mappedBy = "movimentacao")
    private List<MovimentacaoDetalhe> movimentacaoDetalhes;
     */
}
