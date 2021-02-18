package com.api.rest.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDto {
    private Long id;
    @JsonProperty("tipo_contato")
    private Long tipoContato;
    private String valor;
    private String observacao;
}
