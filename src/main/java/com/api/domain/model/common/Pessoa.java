package com.api.domain.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="id_empresa")
    private Empresa empresa;
    @Column
    private String nome;
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    @Column(name = "rg_ie")
    private String rgIe;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @ManyToMany
    @JoinTable(
            name = "pessoa_endereco",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private List<Endereco> enderecos;
    @ManyToMany
    @JoinTable(
            name = "pessoa_contato",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_contato"))
    private List<Contato> contatos;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();
}
