package com.bff.web.application.controller;

import com.bff.web.application.api.BffCustomerDeleteControllerApi;
import com.bff.web.application.api.BffCustomerGetControllerApi;
import com.bff.web.application.api.BffCustomerSaveControllerApi;
import com.bff.web.domain.data.CustomerDTO;
import com.bff.web.domain.ports.api.BffCustomerServicePort;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BffCustomerController implements BffCustomerDeleteControllerApi, BffCustomerGetControllerApi, BffCustomerSaveControllerApi {

    private final BffCustomerServicePort bffCustomerServicePort;
    private static final String CUSTOMER_SERVICE_PORT = "customerServicePort";

    public BffCustomerController(BffCustomerServicePort bffCustomerServicePort){
        this.bffCustomerServicePort = bffCustomerServicePort;
    }

    @Override
    public ResponseEntity<Void> bffDeleteCustomerInformation(String documentNumber) {
        bffCustomerServicePort.deleteCustomerByDocumentNumber(documentNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @CircuitBreaker(name = CUSTOMER_SERVICE_PORT, fallbackMethod = "getCustomerFallBack")
    public ResponseEntity<List<CustomerDTO>> bffGetCustomersInformation() {
        return new ResponseEntity(bffCustomerServicePort.getAllCustomers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerDTO> saveCustomerInformation(CustomerDTO customerDTO) {
        return new ResponseEntity(bffCustomerServicePort.bffSaveCustomer(customerDTO), HttpStatus.OK);
    }

    public ResponseEntity<String> getCustomerFallBack(Exception e){
        return new ResponseEntity<String>("Service is down", HttpStatus.OK);
    }



}
