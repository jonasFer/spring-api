package com.api.domain.model.common;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TipoContato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
