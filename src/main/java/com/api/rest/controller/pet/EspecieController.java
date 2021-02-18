package com.api.rest.controller.pet;

import com.api.builder.pet.EspecieBuilder;
import com.api.rest.dto.PageDto;
import com.api.rest.dto.pet.EspecieDto;
import com.api.service.EspecieService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Pet")
@RestController
@RequestMapping("pet/especie")
public class EspecieController {

    @Autowired
    private EspecieService service;
    @Autowired
    private EspecieBuilder builder;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageDto all(
        @PageableDefault(sort = "dataCriacao", direction = Sort.Direction.ASC, page = 0, size = 10)Pageable pageable
    )
    {
        List<EspecieDto> list = service
                .all(pageable)
                .stream()
                .map(especie -> {
                    return builder.buildDtoFromEntity(especie);
                })
                .collect(Collectors.toList());

        return new PageDto( service.allRegisters(), list);
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
