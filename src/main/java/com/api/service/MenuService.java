package com.api.service;

import com.api.domain.model.common.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> findAll();
    Menu findById(Long id);
    Menu save(Menu menu);
}
