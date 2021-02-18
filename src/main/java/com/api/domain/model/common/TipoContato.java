package com.api.domain.model.common;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class TipoContato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();
}
