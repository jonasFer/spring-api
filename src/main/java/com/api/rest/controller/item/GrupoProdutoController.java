package com.api.rest.controller.item;

import com.api.builder.item.GrupoProdutoBuilder;
import com.api.domain.model.item.GrupoProduto;
import com.api.rest.dto.PageDto;
import com.api.rest.dto.item.GrupoProdutoDto;
import com.api.service.GrupoProdutoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Api(tags = "item")
@RestController
@RequestMapping("item/grupo-produto")
public class GrupoProdutoController {

    @Autowired
    private GrupoProdutoService service;

    @Autowired
    private GrupoProdutoBuilder builder;

    @GetMapping("{id}")
    public ResponseEntity<GrupoProdutoDto> find(@PathVariable Long id)
    {
        return ResponseEntity.ok(
                builder.buildDtoFromEntity(service.findbyId(id))
        );
    }

    @GetMapping
    public ResponseEntity<PageDto> all(@RequestParam(required = false, defaultValue = "") String nome, Pageable pageable) {
        Page<GrupoProduto> page = service.findAll(nome, pageable);
        PageDto response = new PageDto(
                page.getTotalElements(),
                page.toList().stream()
                        .map(grupo -> {
                            return builder.buildDtoFromEntity(grupo);
                        })
                        .collect(Collectors.toList())
        );

        return ResponseEntity.ok(response);
    }
}
