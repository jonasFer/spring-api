package com.api.rest.controller.cliente;

import com.api.builder.pessoa.ClienteBuilder;
import com.api.domain.request.ClienteParam;
import com.api.rest.dto.cliente.ClienteDto;
import com.api.rest.dto.cliente.ClienteLiteDto;
import com.api.service.ClienteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<ClienteLiteDto>> all(@Valid ClienteParam params,  @PageableDefault(sort = "dataCriacao", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        return ResponseEntity.ok(service.findAll(params, paginacao).stream().map(c -> builder.buildLiteDtoFromEntity(c)).collect(Collectors.toList()));
    }
}
