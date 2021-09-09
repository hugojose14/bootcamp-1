package com.bank.scotia.infrastructure.mappers;

import com.bank.scotia.domain.model.ClientRequest;
import com.bank.scotia.infrastructure.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    List<ClientRequest> clientsToClientsDto(List<Client> clients);
}
