package com.bank.scotia.domain.service;

import com.bank.scotia.domain.model.ClientDto;
import com.bank.scotia.domain.model.ClientRequest;
import com.bank.scotia.domain.exceptions.ClientRestrictiveException;
import com.bank.scotia.domain.ports.ClientService;
import com.bank.scotia.infrastructure.mappers.ClientMapper;
import com.bank.scotia.infrastructure.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository,
                             ClientMapper clientMapper){
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDto validateClientInformation(ClientRequest clientRequest) {
        ClientDto clientDto = ClientDto.builder().build();
        List<ClientRequest> restrictiveLists = clientMapper.clientsToClientsDto(clientRepository.findAll());
        restrictiveLists.forEach(clientRestrictive ->validateIfClientIsRestrictiveOrNot(clientRequest, clientRestrictive));
        return setInformationForClient(clientRequest,clientDto);
    }

    private void validateIfClientIsRestrictiveOrNot(ClientRequest clientRequest, ClientRequest client) {
        if(isAClientRestrictive(clientRequest, client)){
            throw new ClientRestrictiveException("The client is reported in the system");
        }
    }

    private ClientDto setInformationForClient(ClientRequest clientRequest, ClientDto clientDto){
        ClientDto clientDtoResponse = ClientDto.builder().name(clientRequest.getName())
                .lastName(clientRequest.getLastName())
                .email(clientRequest.getEmail())
                .documentType(clientRequest.getDocumentType())
                .documentNumber(clientRequest.getDocumentNumber())
                .documentIssueDate(clientRequest.getDocumentIssueDate())
                .birthDate(clientRequest.getBirthDate())
                .cellPhone(clientRequest.getCellPhone())
                .build();
        return clientDtoResponse;
    }

    private boolean isAClientRestrictive(ClientRequest clientRequest, ClientRequest client) {
        return isAClientRestrictiveForEmail(clientRequest, client)
                || isAClientRestrictiveForCellPhone(clientRequest, client)
                || isAClientRestrictiveForNameAndLastNameAndBirthDate(clientRequest, client)
                || isAClientRestrictiveForDocumentTypeAndDocumentNumberAndDocumentIssueDate(clientRequest, client);
    }

    private boolean isAClientRestrictiveForDocumentTypeAndDocumentNumberAndDocumentIssueDate(ClientRequest clientRequest, ClientRequest client) {
        return client.getDocumentType().equals(clientRequest.getDocumentType()) &&
                client.getDocumentNumber().equals(clientRequest.getDocumentNumber())
                && client.getDocumentIssueDate().equals(clientRequest.getDocumentIssueDate());
    }

    private boolean isAClientRestrictiveForNameAndLastNameAndBirthDate(ClientRequest clientRequest, ClientRequest client) {
        return client.getName().toLowerCase().equalsIgnoreCase(clientRequest.getName()) &&
                client.getLastName().toLowerCase().equalsIgnoreCase(clientRequest.getLastName())
                && client.getBirthDate().equals(clientRequest.getBirthDate());
    }

    private boolean isAClientRestrictiveForCellPhone(ClientRequest clientRequest, ClientRequest client) {
        return client.getCellPhone().equals(clientRequest.getCellPhone());
    }

    private boolean isAClientRestrictiveForEmail(ClientRequest clientRequest, ClientRequest client) {
        return client.getEmail().equals(clientRequest.getEmail());
    }
}
