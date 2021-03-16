package com.api.rest.dto.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDto {

    private Long id;

    @ApiModelProperty(value = "Id do tipo de contato", name = "tipoContato", example = "1")
    @NotNull(message = "Tipo de contato é obrigatório")
    private Long tipoContato;

    @ApiModelProperty(value = "Valor do contato", name = "valor", example = "(83) 98888-8888")
    @NotNull(message = "Valor é obrigatório")
    private String valor;

    @ApiModelProperty(value = "Observação sobre o contato", name = "observacao", example = "Ligar das 8h as 18h")
    private String observacao;
}
