package com.api.rest.dto.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RacaDto {
    private Long id;
    @NotNull
    @NotEmpty
    @JsonProperty("id_especie")
    private Long idEspecie;
    private String especie;
    @NotNull @NotEmpty
    private String nome;
}
