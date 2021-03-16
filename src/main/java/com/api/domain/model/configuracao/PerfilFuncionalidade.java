package com.api.domain.model.configuracao;

import com.api.domain.model.configuracao.usuario.Perfil;

import javax.persistence.*;

@Entity
public class PerfilFuncionalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_funcionalidade")
    private Funcionalidade funcionalidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Funcionalidade getFuncionalidade() {
        return funcionalidade;
    }

    public void setFuncionalidade(Funcionalidade funcionalidade) {
        this.funcionalidade = funcionalidade;
    }
}
