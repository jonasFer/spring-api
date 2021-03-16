package com.api.rest.dto.item;

import com.api.domain.model.item.Marca;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    @ApiModelProperty(value = "Id do Produto", name = "id", example = "123")
    private Long id;

    @ApiModelProperty(value = "Id do Tipo de Produto", name = "idTipoProduto", example = "123")
    @NotNull
    private Long idTipoProduto;

    @ApiModelProperty(value = "GTIN(Código de Barras)", name = "gtin", example = "1234567891011")
    private Long gtin;

    @ApiModelProperty(value = "Nome do produto", name = "nome", example = "Produto 1")
    @NotEmpty
    private String nome;

    @ApiModelProperty(value = "Objeto contendo o Grupo do produto", name = "grupoProduto")
    private GrupoProdutoDto grupoProduto;

    @ApiModelProperty(value = "Id do Grupo de Produto", name = "idGrupoProduto", example = "123")
    @NotNull
    private Long idGrupoProduto;

    @ApiModelProperty(value = "Unidade de venda", name = "unidadeVenda", example = "KG")
    @NotEmpty
    private String unidadeVenda;

    @ApiModelProperty(value = "Objeto contendo a marca do produto", name = "marca")
    private Marca marca;

    @ApiModelProperty(value = "Id da Marca", name = "idGrupoProduto", example = "123")
    private Long idMarca;

    @ApiModelProperty(value = "Valor de Custo", name = "valorCusto", example = "1.00")
    private BigDecimal valorCusto;

    @ApiModelProperty(value = "Valor de Venda", name = "valorVenda", example = "1.90")
    @NotNull
    private BigDecimal valorVenda;

    @ApiModelProperty(value = "Status atual do produto", name = "status", example = "false")
    @NotNull
    private Boolean status;

    @ApiModelProperty(value = "Flag que indica se há ou não controle de estoque", name = "controlaEstoque", example = "true")
    @NotNull
    private Boolean controlaEstoque;

    @ApiModelProperty(value = "Quantidade minima em estoque", name = "quantidadeMinima", example = "1")
    private BigDecimal quantidadeMinima;

    @ApiModelProperty(value = "Quantidade máxima em estoque", name = "quantidadeMaxima", example = "50")
    private BigDecimal quantidadeMaxima;
}
