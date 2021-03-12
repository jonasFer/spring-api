package com.api.domain.model.item;

import com.api.domain.model.common.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="id_empresa", nullable = false)
    private Empresa empresa;

    @NotEmpty(message = "Campo nome não pode estar vazio")
    @Column(nullable = false)
    private String nome;

    @JsonIgnore
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();
}
