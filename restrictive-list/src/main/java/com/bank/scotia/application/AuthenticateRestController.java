package com.bank.scotia.application;

import com.bank.scotia.domain.exceptions.UnauthorizedErrorException;
import com.bank.scotia.domain.model.AuthenticationRequest;
import com.bank.scotia.domain.model.AuthenticationResponse;
import com.bank.scotia.domain.service.MyUserDetailsService;
import com.bank.scotia.application.controllers.AuthenticateControllerApi;
import com.bank.scotia.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateRestController implements AuthenticateControllerApi {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JwtUtil jwtTokenUtil;

    public AuthenticateRestController(AuthenticationManager authenticationManager,
                                      MyUserDetailsService userDetailsService,
                                      JwtUtil jwtTokenUtil){
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        }
        catch(BadCredentialsException badCredentialsException){
            throw new UnauthorizedErrorException("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(
                authenticationRequest.getUsername()
        );

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
