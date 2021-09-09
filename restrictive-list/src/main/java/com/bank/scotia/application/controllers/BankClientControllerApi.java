/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bank.scotia.application.controllers;

import com.bank.scotia.domain.model.ClientDto;
import com.bank.scotia.domain.model.ClientRequest;
import com.bank.scotia.domain.model.ResponseClientDTO;
import com.bank.scotia.domain.model.ResponseError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-04T10:06:57.212-05:00[America/Bogota]")
@Validated
@Api(value = "BankClientController", description = "the BankClientController API")
public interface BankClientControllerApi {

    /**
     * POST /client
     *
     * @param clientRequest  (required)
     * @return OK (status code 200)
     *         or BADREQUEST (status code 400)
     */
    @ApiOperation(value = "", nickname = "requestValidateClientInformation", notes = "", response = ResponseClientDTO.class, tags={ "bank-client-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ClientDto.class),
        @ApiResponse(code = 400, message = "BADREQUEST", response = ResponseError.class) })
    @ApiImplicitParams({
    })
    @PostMapping(
        value = "/client",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<ClientDto> requestValidateClientInformation(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ClientRequest clientRequest);

}
