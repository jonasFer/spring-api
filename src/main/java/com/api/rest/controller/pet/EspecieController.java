package com.api.rest.controller.pet;

import com.api.builder.model.pet.EspecieBuilder;
import com.api.rest.dto.pet.EspecieDto;
import com.api.service.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pet/especie")
public class EspecieController {

    @Autowired
    private EspecieService service;
    @Autowired
    private EspecieBuilder builder;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EspecieDto> all()
    {
        return service
                .all()
                .stream()
                .map(especie -> {
                    EspecieDto dto = new EspecieDto();
                    dto.setId(especie.getId());
                    dto.setNome(especie.getNome());

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public EspecieDto find(@PathVariable Long id) {
        return builder.buildDtoFromEntity(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EspecieDto save(@RequestBody EspecieDto dto) {
        return builder.buildDtoFromEntity(service.save(builder.builEntityFromDto(dto)));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public EspecieDto update(@PathVariable Long id, @RequestBody @Valid EspecieDto dto)
    {
        return builder.buildDtoFromEntity(service.update(id, builder.builEntityFromDto(dto)));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
