package com.api.rest.dto.cliente;

import com.api.rest.dto.common.ContatoDto;
import com.api.rest.dto.common.EnderecoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private Long id;
    private String nome;
    private Long tipo;
    private String cpfCnpj;
    private String rgIe;
    private String dataNascimento;
    private List<ContatoDto> contatos;
    private List<EnderecoDto> enderecos;
}
