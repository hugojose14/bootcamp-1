/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.scotia.customer.application.api;

import com.scotia.customer.application.command.CustomerRequest;
import com.scotia.customer.domain.data.CustomerDTO;
import com.scotia.customer.domain.data.ResponseCustomerDTO;
import com.scotia.customer.domain.data.ResponseError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-20T16:03:56.853-05:00[America/Bogota]")
@Validated
@Api(value = "CustomerSaveController", description = "the CustomerSaveController API")
public interface CustomerSaveControllerApi {

    /**
     * POST /customers : Save customer
     *
     * @param customerRequest  (required)
     * @return OK (status code 200)
     *         or BADREQUEST (status code 400)
     */
    @ApiOperation(value = "Save customer", nickname = "saveCustomerInformation", notes = "", response = ResponseCustomerDTO.class, tags={ "customer-save-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CustomerDTO.class),
        @ApiResponse(code = 400, message = "BADREQUEST", response = ResponseError.class) })
    @ApiImplicitParams({
    })
    @PostMapping(
        value = "/customers",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    @CrossOrigin(origins = "*")
    ResponseEntity<CustomerDTO> saveCustomerInformation(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CustomerRequest customerRequest);

}
