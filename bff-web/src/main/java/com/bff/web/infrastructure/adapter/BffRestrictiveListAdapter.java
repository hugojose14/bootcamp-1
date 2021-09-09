package com.bff.web.infrastructure.adapter;

import com.bff.web.domain.data.AuthenticationRequest;
import com.bff.web.domain.data.AuthenticationResponse;
import com.bff.web.domain.data.ClientDTO;
import com.bff.web.domain.data.ClientRequest;
import com.bff.web.domain.exception.ClientRestrictiveException;
import com.bff.web.domain.exception.UnauthorizedErrorException;
import com.bff.web.domain.ports.rest.BffRestrictiveListRestPort;
import com.bff.web.infrastructure.feing.RestrictiveListClient;
import feign.FeignException;
import org.springframework.stereotype.Service;

@Service
public class BffRestrictiveListAdapter implements BffRestrictiveListRestPort {

    private final RestrictiveListClient restrictiveListClient;

    public BffRestrictiveListAdapter(RestrictiveListClient restrictiveListClient){
        this.restrictiveListClient = restrictiveListClient;
    }

    @Override
    public AuthenticationResponse bffRestrictiveListGenerateAuthentication(AuthenticationRequest authenticationRequest) {
        try{
            return restrictiveListClient.generateAuthentication(authenticationRequest);
        }catch (FeignException.Unauthorized unauthorizedException){
            throw new UnauthorizedErrorException("Incorrect username or password");
        }
    }

    @Override
    public ClientDTO bffRestrictiveListValidateClient(ClientRequest clientRequest,String securityAuthorization) {
        try {
            return restrictiveListClient.verifyClientListRestrictiveList(clientRequest,securityAuthorization);
        }catch (FeignException.Unauthorized unauthorizedException){
            throw new UnauthorizedErrorException("Unauthorized resource");
        }
        catch (FeignException.BadRequest badRequestException){
            throw  new ClientRestrictiveException("The client is reported in the system");
        }
    }
}
