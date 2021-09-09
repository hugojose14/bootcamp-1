package com.scotia.customer.application.controller;

import com.scotia.customer.application.api.CustomerDeleteControllerApi;
import com.scotia.customer.application.api.CustomerGetControllerApi;
import com.scotia.customer.application.api.CustomerSaveControllerApi;
import com.scotia.customer.application.handler.CreateCustomerHandler;
import com.scotia.customer.domain.data.CustomerDTO;
import com.scotia.customer.domain.ports.api.CustomerServicePort;
import com.scotia.customer.application.command.CustomerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomerDeleteControllerApi, CustomerGetControllerApi, CustomerSaveControllerApi {

    private final  CustomerServicePort customerServicePort;
    private final CreateCustomerHandler createCustomerHandler;

    public CustomerController(CustomerServicePort customerServicePort,CreateCustomerHandler createCustomerHandler){
        this.customerServicePort = customerServicePort;
        this.createCustomerHandler = createCustomerHandler;
    }

    @Override
    public ResponseEntity<Void> deleteCustomerInformation(String documentNumber) {
        customerServicePort.deleteCustomerByDocumentNumber(documentNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<CustomerRequest>> getCustomersInformation() {
        return new ResponseEntity(customerServicePort.getCustomers(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerDTO> saveCustomerInformation(CustomerRequest customerRequest) {
        return new ResponseEntity(createCustomerHandler.execute(customerRequest), HttpStatus.OK);
    }
}
