package com.api.rest.dto.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {
    private Long id;
    @NotNull
    private Long pessoa;
    @NotNull
    private String nome;
    private String sexo;
    @JsonProperty("data_nascimento")
    private String dataNascimento;
    private Long especie;
    private Long raca;
    private Long pelagem;
}
