package com.api.rest.controller.pet;

import com.api.builder.pet.AnimalBuilder;
import com.api.rest.dto.PageDto;
import com.api.rest.dto.pet.AnimalDto;
import com.api.service.AnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = {"Animal"}, value = "pet/animal", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("pet/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;
    @Autowired
    private AnimalBuilder builder;

    @ApiOperation(
            value = "Listar animal pelo id",
            httpMethod = "GET"
    )
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDto find(@PathVariable Long id) throws ParseException {
        return builder.buildDtoFromEntity(animalService.byId(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageDto all() {
        List<AnimalDto> list = animalService
                .all()
                .stream()
                .map(animal -> {
                    try {
                        return builder.buildDtoFromEntity(animal);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());

        return new PageDto(animalService.allRegisters(), list);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalDto create(@RequestBody @Valid AnimalDto animalDto) throws ParseException {
        return builder.buildDtoFromEntity(
                animalService.create(builder.buidEntityFromDto(animalDto))
        );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnimalDto update(@PathVariable Long id, @RequestBody @Valid AnimalDto animalDto) throws ParseException {
        return builder
                .buildDtoFromEntity(
                        animalService.update(id, builder.buidEntityFromDto(animalDto))
                );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        animalService.delete(id);
    }
}
