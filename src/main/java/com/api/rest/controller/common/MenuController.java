package com.api.rest.controller.common;

import com.api.application.builder.model.MenuBuilder;
import com.api.rest.dto.common.MenuDto;
import com.api.service.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Menu")
@RestController
@RequestMapping("common/menu")
public class MenuController {

    @Autowired
    private MenuService service;

    @Autowired
    private MenuBuilder builder;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MenuDto> all()
    {
        return service
                .findAll()
                .stream()
                .map(menu -> builder.buildDtoFromEntity(menu))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenuDto save(@RequestBody MenuDto menuDto) {
        return builder.buildDtoFromEntity(service.save(builder.builEntityFromDto(menuDto)));
    }
}
