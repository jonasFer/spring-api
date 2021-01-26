package com.api.domain.model.common;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name="id_menu_pai", nullable=true)
    private Menu menuPai;

    @OneToMany(mappedBy="menuPai")
    private List<Menu> submenus = new ArrayList<>();

    public Menu() { }

    public Menu(String nome, Menu menuPai) {
        this.nome = nome;
        this.menuPai = menuPai;
    }

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

    public Menu getMenuPai() {
        return menuPai;
    }

    public void setMenuPai(Menu menuPai) {
        this.menuPai = menuPai;
    }

    public List<Menu> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(List<Menu> submenus) {
        this.submenus = submenus;
    }
}
