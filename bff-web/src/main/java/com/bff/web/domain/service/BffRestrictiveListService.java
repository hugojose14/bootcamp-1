package com.bff.web.domain.service;

import com.bff.web.domain.data.AuthenticationRequest;
import com.bff.web.domain.data.AuthenticationResponse;
import com.bff.web.domain.data.ClientDTO;
import com.bff.web.domain.data.ClientRequest;
import com.bff.web.domain.ports.api.BFfRestrictiveListServicePort;
import com.bff.web.domain.ports.rest.BffCustomerRestPort;
import com.bff.web.domain.ports.rest.BffRestrictiveListRestPort;
import org.springframework.http.ResponseEntity;

public class BffRestrictiveListService implements BFfRestrictiveListServicePort {

    private final BffRestrictiveListRestPort bffRestrictiveListRestPort;

    public BffRestrictiveListService(BffRestrictiveListRestPort bffRestrictiveListRestPort){
        this.bffRestrictiveListRestPort = bffRestrictiveListRestPort;
    }

    @Override
    public AuthenticationResponse bffRestrictiveListGenerateAuthentication(AuthenticationRequest authenticationRequest) {
        return bffRestrictiveListRestPort.bffRestrictiveListGenerateAuthentication(authenticationRequest);
    }

    @Override
    public ClientDTO bffRestrictiveListValidateClient(ClientRequest clientRequest,String securityAuthorization) {
        return bffRestrictiveListRestPort.bffRestrictiveListValidateClient(clientRequest, securityAuthorization);
    }
}
