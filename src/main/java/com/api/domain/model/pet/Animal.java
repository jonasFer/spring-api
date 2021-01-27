package com.api.domain.model.pet;

import com.api.domain.model.common.Pessoa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="id_pessoa")
    private Pessoa pessoa;
    @Column
    private String nome;
    @Column
    private String sexo;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @ManyToOne
    @JoinColumn(name = "id_especie")
    private Especie especie;
    @ManyToOne
    @JoinColumn(name = "id_raca")
    private Raca raca;
    @ManyToOne
    @JoinColumn(name = "id_pelagem")
    private Pelagem pelagem;
    // Fica pendente a foto

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public Pelagem getPelagem() {
        return pelagem;
    }

    public void setPelagem(Pelagem pelagem) {
        this.pelagem = pelagem;
    }
}
