package com.api.rest.dto.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {
    @ApiModelProperty(value = "Id do endereço", name = "id", example = "1", position = 0)
    private Long id;

    @ApiModelProperty(value = "Endereço", name = "logradouro", example = "Rua dos Alfeneiros", position = 1)
    private String logradouro;

    @ApiModelProperty(value = "Número da Residência", name = "numero", example = "4", position = 2)
    private String numero;

    @ApiModelProperty(value = "CEP", name = "cep", example = "58306160", position = 3)
    private String cep;

    @ApiModelProperty(value = "Complemento", name = "complemento", example = "Armário embaixo da escada", position = 4)
    private String complemento;

    @ApiModelProperty(value = "Bairro", name = "bairro", example = "Centro", position = 5)
    private String bairro;

    @ApiModelProperty(value = "Municipio", name = "municipio", example = "Bayeux", position = 6)
    private String municipio;

    @ApiModelProperty(value = "Id do estadoP", name = "estado", example = "1", position = 7)
    private Long estado;
}
