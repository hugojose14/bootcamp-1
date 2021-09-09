package com.bff.web.domain.ports.rest;

import com.bff.web.domain.data.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BffRestrictiveListRestPort {
    AuthenticationResponse bffRestrictiveListGenerateAuthentication(AuthenticationRequest authenticationRequest);
    ClientDTO bffRestrictiveListValidateClient(ClientRequest clientRequest,String securityAuthorization);
}
