package com.api.service.impl;

import com.api.domain.model.common.Menu;
import com.api.domain.repository.MenuRepository;
import com.api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public List<Menu> findAll() {
        return repository.findByMenuPaiIsNull();
    }

    public Menu findById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu não encontrado")
                );
    }

    @Override
    public Menu save(Menu menu) {
        return repository.save(menu);
    }
}
