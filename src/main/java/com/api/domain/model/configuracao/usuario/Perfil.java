package com.api.domain.model.configuracao.usuario;

import com.api.domain.model.common.Empresa;
import com.api.domain.model.configuracao.PerfilFuncionalidade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name ="id_empresa")
    private Empresa empresa;
    private String nome;
    @OneToMany(mappedBy = "perfil")
    private List<PerfilFuncionalidade> perfilFuncionalidades;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PerfilFuncionalidade> getPerfilFuncionalidades() {
        return perfilFuncionalidades;
    }

    public void setPerfilFuncionalidades(List<PerfilFuncionalidade> perfilFuncionalidades) {
        this.perfilFuncionalidades = perfilFuncionalidades;
    }
}
