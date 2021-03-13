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
    @JsonProperty("id_especie")
    private Long idEspecie;

    private String especie;

    @NotEmpty
    private String nome;
}
