package com.api.rest.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {
    private Long id;
    private String logradouro;
    private String numero;
    private String cep;
    private String complemento;
    private String bairro;
    private String municipio;
    private Long estado;
}
