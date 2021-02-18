package com.api.rest.controller.cliente;

import com.api.builder.pessoa.ClienteBuilder;
import com.api.rest.dto.cliente.ClienteDto;
import com.api.rest.dto.cliente.ClienteLiteDto;
import com.api.service.ClienteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Cliente")
@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteBuilder builder;

    @Autowired
    private ClienteService service;

    @GetMapping("{id}")
    public ResponseEntity<ClienteDto> find(@PathVariable Long id) throws ParseException {
        return ResponseEntity.ok(builder.buildDtoFromEntity(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ClienteLiteDto>> all() {
        return ResponseEntity.ok(service.findAll().stream().map(c -> builder.buildLiteDtoFromEntity(c)).collect(Collectors.toList()));
    }
}
