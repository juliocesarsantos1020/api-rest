package br.com.estudos.api.mapper;

import br.com.estudos.api.domain.Cliente;
import br.com.estudos.api.dto.ClienteCadastroDTO;
import br.com.estudos.api.dto.ListaDeClientesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mappings({
            @Mapping(target = "nome", source = "clienteCadastroDto.nome"),
            @Mapping(target = "email", source = "clienteCadastroDto.email")
    })
    Cliente converterParaDominio(ClienteCadastroDTO clienteCadastroDto);

    @Mappings({
            @Mapping(target = "id", source = "cliente.id")
    })
    ListaDeClientesDTO converterParaListaDTO(Cliente cliente);
}