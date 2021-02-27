package com.api.domain.model.pet;

import com.api.domain.model.Cliente;
import com.api.domain.model.common.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="id_cliente")
    private Cliente cliente;
    @Column
    private String nome;
    @Column
    private String sexo;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @ManyToOne
    @JoinColumn(name = "id_especie")
    private Especie especie;
    @ManyToOne
    @JoinColumn(name = "id_raca")
    private Raca raca;
    @ManyToOne
    @JoinColumn(name = "id_pelagem")
    private Pelagem pelagem;
    // Fica pendente a foto
}
