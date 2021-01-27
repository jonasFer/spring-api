package com.api.rest.controller.pet;

import com.api.builder.model.pet.PelagemBuilder;
import com.api.rest.dto.pet.PelagemDto;
import com.api.service.PelagemService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Pelagem")
@RestController
@RequestMapping("pelagem")
public class PelagemController {
    @Autowired
    private PelagemService service;
    @Autowired
    private PelagemBuilder builder;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PelagemDto> all()
    {
        return service
                .all()
                .stream()
                .map(especie -> {
                    PelagemDto dto = new PelagemDto();
                    dto.setId(especie.getId());
                    dto.setNome(especie.getNome());

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PelagemDto find(@PathVariable Long id) {
        return builder.buildDtoFromEntity(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PelagemDto save(@RequestBody @Valid PelagemDto dto) {
        return builder.buildDtoFromEntity(service.save(builder.builEntityFromDto(dto)));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PelagemDto update(@PathVariable Long id, @RequestBody @Valid PelagemDto dto)
    {
        return builder.buildDtoFromEntity(service.update(id, builder.builEntityFromDto(dto)));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
