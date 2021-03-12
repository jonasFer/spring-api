package com.api.rest.controller.item;

import com.api.builder.item.GrupoProdutoBuilder;
import com.api.domain.model.item.GrupoProduto;
import com.api.rest.dto.PageDto;
import com.api.rest.dto.item.GrupoProdutoDto;
import com.api.service.GrupoProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Api(tags = "Item / Grupo Produto", value = "pet/animal", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("item/grupo-produto")
public class GrupoProdutoController {

    @Autowired
    private GrupoProdutoService service;

    @Autowired
    private GrupoProdutoBuilder builder;

    @ApiOperation(
            value = "Listar Grupo de produto pelo id",
            response = GrupoProdutoDto.class,
            httpMethod = "GET"
    )
    @GetMapping("{id}")
    public ResponseEntity<GrupoProdutoDto> find(@PathVariable Long id)
    {
        return ResponseEntity.ok(
                builder.buildDtoFromEntity(service.findbyId(id))
        );
    }

    @ApiOperation(
            value = "Listar Grupos de produtos",
            response = PageDto.class,
            httpMethod = "GET"
    )
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

    @ApiOperation(
            value = "Cadastrar Grupo de produto",
            response = GrupoProdutoDto.class,
            httpMethod = "POST"
    )
    @PostMapping
    public ResponseEntity<GrupoProdutoDto> save(@Valid @RequestBody GrupoProdutoDto grupo) {
        GrupoProduto grupoProduto = service.save(builder.buildEntityFromDto(grupo));

        return ResponseEntity.ok(
                builder.buildDtoFromEntity(grupoProduto)
        );
    }

    @ApiOperation(
            value = "Atualizar Grupo de produto",
            response = GrupoProdutoDto.class,
            httpMethod = "PUT"
    )
    @PutMapping("{id}")
    public ResponseEntity<GrupoProdutoDto> update(@PathVariable Long id, @Valid @RequestBody GrupoProdutoDto grupo) {
        GrupoProduto grupoProduto = service.update(id, builder.buildEntityFromDto(grupo));

        return ResponseEntity.ok(
                builder.buildDtoFromEntity(grupoProduto)
        );
    }

    @ApiOperation(
            value = "Deletar Grupo de produto",
            response = Void.class,
            httpMethod = "DELETE"
    )
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }
}
