package com.bff.web.application.controller;

import com.bff.web.application.api.BffRestrictiveListAuthenticateMethodApi;
import com.bff.web.application.api.BffRestrictiveListControllerApi;
import com.bff.web.domain.data.AuthenticationRequest;
import com.bff.web.domain.data.AuthenticationResponse;
import com.bff.web.domain.data.ClientDTO;
import com.bff.web.domain.data.ClientRequest;
import com.bff.web.domain.ports.api.BFfRestrictiveListServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BffRestrictiveListController implements BffRestrictiveListControllerApi, BffRestrictiveListAuthenticateMethodApi {

    private final BFfRestrictiveListServicePort bffRestrictiveListServicePort;

    public BffRestrictiveListController(BFfRestrictiveListServicePort bFfRestrictiveListServicePort){
        this.bffRestrictiveListServicePort = bFfRestrictiveListServicePort;
    }

    @Override
    public ResponseEntity<AuthenticationResponse> bffRestrictiveListGenerateAuthentication(AuthenticationRequest authenticationRequest) {
        return new ResponseEntity<>(bffRestrictiveListServicePort.bffRestrictiveListGenerateAuthentication(authenticationRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientDTO> bffRestrictiveListValidateClient(ClientRequest clientRequest, String securityAuthorization) {
        return new ResponseEntity(bffRestrictiveListServicePort.bffRestrictiveListValidateClient(clientRequest,securityAuthorization), HttpStatus.OK);
    }
}
