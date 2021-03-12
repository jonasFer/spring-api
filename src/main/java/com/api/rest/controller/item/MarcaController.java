package com.api.rest.controller.item;

import com.api.domain.model.item.Marca;
import com.api.rest.dto.PageDto;
import com.api.service.MarcaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Item / Marca")
@RestController
@RequestMapping("item/marca")
public class MarcaController {
    @Autowired
    private MarcaService service;

    @GetMapping
    public ResponseEntity<PageDto> all(
            @RequestParam(required = false) String nome,
            Pageable pageable
    ) {
        Page<Marca> page = service.findAll(nome, pageable);
        PageDto response = new PageDto(page.getTotalElements(), page.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<Marca> find(@PathVariable Long id) {
        return ResponseEntity.ok(service.findbyId(id));
    }

    @PostMapping
    public ResponseEntity<Marca> save(@Valid @RequestBody Marca marca)
    {
        return ResponseEntity.ok(service.save(marca));
    }

    @PutMapping("{id}")
    public ResponseEntity<Marca> update(@PathVariable Long id, @Valid @RequestBody Marca marca)
    {
        return ResponseEntity.ok(service.update(id, marca));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }
}
