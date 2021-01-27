package com.api.rest.dto.pet;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RacaDto {
    private Long id;
    @NotNull @NotEmpty
    private Long especie;
    @NotNull @NotEmpty
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEspecie() {
        return especie;
    }

    public void setEspecie(Long especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
