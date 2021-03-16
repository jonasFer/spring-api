package com.api.rest.dto.pet;

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
    private Long idEspecie;

    private String especie;

    @NotEmpty
    private String nome;
}
