package com.api.rest.dto.pet;

public class EspecieDto {
    private Long id;
    private String nome;

    public EspecieDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
