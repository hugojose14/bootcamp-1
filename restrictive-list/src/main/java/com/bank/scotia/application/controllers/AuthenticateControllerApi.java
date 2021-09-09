package com.bank.scotia.application.controllers;

import com.bank.scotia.domain.model.AuthenticationRequest;
import com.bank.scotia.domain.model.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface AuthenticateControllerApi {

    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest
            ) throws Exception;
}
