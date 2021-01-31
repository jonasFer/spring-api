package com.api.rest.controller.pet;

import com.api.application.builder.model.pet.RacaBuilder;
import com.api.rest.dto.PageDto;
import com.api.rest.dto.pet.RacaDto;
import com.api.service.RacaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Pet")
@RestController
@RequestMapping("pet/raca")
public class RacaController {

    @Autowired
    private RacaService racaService;
    @Autowired
    private RacaBuilder builder;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public RacaDto find(@PathVariable Long id) {
        return builder.buildDtoFromEntity(racaService.byId(id));
    }

    @GetMapping("/especie/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<RacaDto> findAllByEspecie(@PathVariable Long id) {
        return racaService
                .allByEspecie(id)
                .stream()
                .map(raca -> builder.buildDtoFromEntity(raca))
                .collect(Collectors.toList());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageDto all() {
        List<RacaDto> list = racaService
                .all()
                .stream()
                .map(raca -> builder.buildDtoFromEntity(raca))
                .collect(Collectors.toList());

        return new PageDto(racaService.allRegisters(), list);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RacaDto create(@RequestBody @Valid RacaDto racaDto) {
        return builder
                .buildDtoFromEntity(
                        racaService.create(builder.builEntityFromDto(racaDto))
                );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public RacaDto update(@PathVariable Long id, @RequestBody @Valid RacaDto racaDto) {
        return builder
                .buildDtoFromEntity(
                        racaService.update(id, builder.builEntityFromDto(racaDto))
                );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        racaService.delete(id);
    }
}
