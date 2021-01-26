package com.api.rest.dto.common;

import java.util.List;

public class MenuDto {
    private Long id;
    private String nome;
    private List<MenuDto> submenus;
    private Long MenuPai;

    public MenuDto(){ }

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

    public List<MenuDto> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(List<MenuDto> submenus) {
        this.submenus = submenus;
    }

    public Long getMenuPai() {
        return MenuPai;
    }

    public void setMenuPai(Long menuPai) {
        MenuPai = menuPai;
    }
}
