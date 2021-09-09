package com.bff.web.infrastructure.feing;

import com.bff.web.domain.data.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "restrictive-list-integration", url = "${url.component.restrictive-list}")
public interface RestrictiveListClient {

    @RequestMapping(method = RequestMethod.POST, value = "/client",produces = "application/json")
    ClientDTO verifyClientListRestrictiveList(ClientRequest clientRequest,@RequestHeader ("security") String securityAuthorization);

    @RequestMapping(method = RequestMethod.POST, value="/authenticate",produces = "application/json")
    AuthenticationResponse generateAuthentication(AuthenticationRequest authenticationRequest);

}
