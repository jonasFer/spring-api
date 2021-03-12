package com.api.rest.dto.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrupoProdutoDto {

    private Long id;

    @NotEmpty
    private String nome;

    @NotNull
    private Boolean status;

    private List<GrupoProdutoDto> subGrupos;

    private Long idGrupoPai;
}
