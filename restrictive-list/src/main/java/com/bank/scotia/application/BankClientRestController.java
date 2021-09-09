package com.bank.scotia.application;

import com.bank.scotia.domain.model.ClientDto;
import com.bank.scotia.domain.model.ClientRequest;
import com.bank.scotia.application.controllers.BankClientControllerApi;
import com.bank.scotia.domain.ports.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankClientRestController implements BankClientControllerApi {

    private final ClientService clientService;

    public BankClientRestController(ClientService clientService){
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<ClientDto> requestValidateClientInformation(ClientRequest clientRequest) {
        return new ResponseEntity(clientService.validateClientInformation(clientRequest), HttpStatus.OK);
    }
}
