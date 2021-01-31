package com.api.application.builder.model;

import com.api.domain.model.common.Menu;
import com.api.rest.dto.common.MenuDto;
import com.api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MenuBuilder {
    @Autowired
    private MenuService service;

    public Menu builEntityFromDto(MenuDto dto) {
        Menu menu = new Menu();
        menu.setNome(dto.getNome());
        menu.setMenuPai(service.findById(dto.getMenuPai()));

        return menu;
    }

    public MenuDto buildDtoFromEntity(Menu menu) {
        MenuDto dto = new MenuDto();
        dto.setId(menu.getId());
        dto.setNome(menu.getNome());
        dto.setSubmenus(menu.getSubmenus().stream().map(m -> this.buildDtoFromEntity(m)).collect(Collectors.toList()));

        return dto;
    }
}
