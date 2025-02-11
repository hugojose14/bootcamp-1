/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bff.web.application.api;

import com.bff.web.domain.data.CustomerDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-25T10:27:54.842-05:00[America/Bogota]")
@Validated
@Api(value = "BffCustomerGetController", description = "the BffCustomerGetController API")
public interface BffCustomerGetControllerApi {

    /**
     * GET /bff/crm : Get customers
     *
     * @return OK (status code 200)
     */
    @ApiOperation(value = "Get customers", nickname = "bffGetCustomersInformation", notes = "", response = CustomerDTO.class, responseContainer = "List", tags={ "bff-customer-get-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CustomerDTO.class, responseContainer = "List") })
    @ApiImplicitParams({
    })
    @GetMapping(
        value = "/bff/crm",
        produces = { "application/json" }
    )
    @CrossOrigin(origins = "*")
    ResponseEntity<List<CustomerDTO>> bffGetCustomersInformation();

}
