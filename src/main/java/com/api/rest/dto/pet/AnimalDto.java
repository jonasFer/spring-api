package com.api.rest.dto.pet;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

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

    public AnimalDto() {  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPessoa() {
        return pessoa;
    }

    public void setPessoa(Long pessoa) {
        this.pessoa = pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getEspecie() {
        return especie;
    }

    public void setEspecie(Long especie) {
        this.especie = especie;
    }

    public Long getRaca() {
        return raca;
    }

    public void setRaca(Long raca) {
        this.raca = raca;
    }

    public Long getPelagem() {
        return pelagem;
    }

    public void setPelagem(Long pelagem) {
        this.pelagem = pelagem;
    }
}
