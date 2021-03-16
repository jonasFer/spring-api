package com.api.domain.model.configuracao;

import javax.persistence.*;
import java.util.List;

@Entity
public class Funcionalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "funcionalidade")
    private List<PerfilFuncionalidade> perfilFuncionalidade;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PerfilFuncionalidade> getPerfilFuncionalidade() {
        return perfilFuncionalidade;
    }

    public void setPerfilFuncionalidade(List<PerfilFuncionalidade> perfilFuncionalidade) {
        this.perfilFuncionalidade = perfilFuncionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
