/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.scotia.customer.application.api;

import com.scotia.customer.application.command.CustomerRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-20T16:03:56.853-05:00[America/Bogota]")
@Validated
@Api(value = "CustomerGetController", description = "the CustomerGetController API")
public interface CustomerGetControllerApi {

    /**
     * GET /customers : Get customers
     *
     * @return OK (status code 200)
     */
    @ApiOperation(value = "Get customers", nickname = "getCustomersInformation", notes = "", response = CustomerRequest.class, responseContainer = "List", tags={ "customer-get-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CustomerRequest.class, responseContainer = "List") })
    @ApiImplicitParams({
    })
    @GetMapping(
        value = "/customers",
        produces = { "application/json" }
    )
    @CrossOrigin(origins = "*")
    ResponseEntity<List<CustomerRequest>> getCustomersInformation();

}
