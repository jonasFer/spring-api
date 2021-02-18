package com.api.rest.dto.cliente;

import com.api.rest.dto.pet.AnimalDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteLiteDto {
    private Long id;
    private String nome;
    private List<AnimalDto> animais;
}
