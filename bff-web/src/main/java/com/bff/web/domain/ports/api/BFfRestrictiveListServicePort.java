package com.bff.web.domain.ports.api;

import com.bff.web.domain.data.AuthenticationRequest;
import com.bff.web.domain.data.AuthenticationResponse;
import com.bff.web.domain.data.ClientDTO;
import com.bff.web.domain.data.ClientRequest;
import org.springframework.http.ResponseEntity;

public interface BFfRestrictiveListServicePort {
    AuthenticationResponse bffRestrictiveListGenerateAuthentication(AuthenticationRequest authenticationRequest);
    ClientDTO bffRestrictiveListValidateClient(ClientRequest clientRequest, String securityAuthorization);
}
