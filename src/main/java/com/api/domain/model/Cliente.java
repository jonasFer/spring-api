package com.api.domain.model;

import com.api.domain.model.common.Pessoa;
import com.api.domain.model.pet.Animal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="id_pessoa")
    private Pessoa pessoa;
    @OneToMany(mappedBy="cliente")
    private List<Animal> animais = new ArrayList<>();
}
