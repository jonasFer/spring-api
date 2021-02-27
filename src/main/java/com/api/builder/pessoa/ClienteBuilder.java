package com.api.builder.pessoa;

import com.api.builder.common.ContatoBuilder;
import com.api.builder.common.EnderecoBuilder;
import com.api.builder.pet.AnimalBuilder;
import com.api.domain.model.Cliente;
import com.api.rest.dto.cliente.ClienteDto;
import com.api.rest.dto.cliente.ClienteLiteDto;
import com.api.service.AnimalService;
import com.api.util.DataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClienteBuilder {
    @Autowired
    private EnderecoBuilder enderecoBuilder;

    @Autowired
    private ContatoBuilder contatoBuilder;

    @Autowired
    private AnimalBuilder animalBuilder;

    public Cliente builEntityFromDto(ClienteDto dto) {
        return Cliente.builder().build();
    }

    public ClienteDto buildDtoFromEntity(Cliente cliente) throws ParseException {
        return ClienteDto
                .builder()
                .id(cliente.getId())
                .nome(cliente.getPessoa().getNome())
                .rgIe(cliente.getPessoa().getRgIe())
                .cpfCnpj(cliente.getPessoa().getCpfCnpj())
                .enderecos(cliente.getPessoa().getEnderecos().stream().map(e -> this.enderecoBuilder.buildDtoFromEntity(e)).collect(Collectors.toList()))
                .contatos(cliente.getPessoa().getContatos().stream().map(c -> this.contatoBuilder.buildDtoFromEntity(c)).collect(Collectors.toList()))
                .dataNascimento(DataConverter.convertDateToString(cliente.getPessoa().getDataNascimento()))
                .build();
    }

    public ClienteLiteDto buildLiteDtoFromEntity(Cliente cliente) {
        return ClienteLiteDto
                .builder()
                .id(cliente.getId())
                .nome(cliente.getPessoa().getNome())
                .animais(cliente.getAnimais().stream().map(a -> this.animalBuilder.buildLiteDtoFromEntity(a)).collect(Collectors.toList()))
                .build();
    }
}
