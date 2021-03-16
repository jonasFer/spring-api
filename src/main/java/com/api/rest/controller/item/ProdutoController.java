package com.api.rest.controller.item;

import com.api.builder.item.ProdutoBuilder;
import com.api.domain.model.item.Produto;
import com.api.rest.dto.PageDto;
import com.api.rest.dto.item.ProdutoDto;
import com.api.service.ProdutoService;
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

@Api(tags = "Item / Produto", value = "item/produto", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("item/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoBuilder builder;

    @ApiOperation(
            value = "Listar produto pelo id",
            response = ProdutoDto.class,
            httpMethod = "GET"
    )
    @GetMapping("{id}")
    public ResponseEntity<ProdutoDto> find(@PathVariable Long id)
    {
        return ResponseEntity.ok(
                builder.buildDtoFromEntity(service.findbyId(id))
        );
    }

    @ApiOperation(
            value = "Listar produtos",
            response = PageDto.class,
            httpMethod = "GET"
    )
    @GetMapping
    public ResponseEntity<PageDto> all(Pageable pageable) {
        Page<Produto> page = service.findAll(pageable);
        PageDto response = new PageDto(
                page.getTotalElements(),
                page.toList().stream()
                        .map(produto -> {
                            return builder.buildDtoFromEntity(produto);
                        })
                        .collect(Collectors.toList())
        );

        return ResponseEntity.ok(response);
    }

    @ApiOperation(
            value = "Cadastrar produto",
            response = ProdutoDto.class,
            httpMethod = "POST"
    )
    @PostMapping
    public ResponseEntity<ProdutoDto> create(@Valid @RequestBody ProdutoDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @ApiOperation(
            value = "Atualizar produto",
            response = ProdutoDto.class,
            httpMethod = "PUT"
    )

    @PutMapping("{id}")
    public ResponseEntity<ProdutoDto> update(@PathVariable Long id, @Valid @RequestBody ProdutoDto dto) {
        return ResponseEntity.ok(service.edit(id,dto));
    }

    @ApiOperation(
            value = "Deletar produto",
            response = Void.class,
            httpMethod = "DELETE"
    )
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }
}
