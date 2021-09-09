package com.bff.web.domain.service;


import com.bff.web.domain.data.CustomerDTO;
import com.bff.web.domain.ports.api.BffCustomerServicePort;
import com.bff.web.domain.ports.rest.BffCustomerRestPort;

import java.util.List;

public class BffCustomerService implements BffCustomerServicePort {

    private final BffCustomerRestPort bffCustomerRestPort;

    public BffCustomerService(BffCustomerRestPort bffCustomerRestPort){
        this.bffCustomerRestPort = bffCustomerRestPort;
    }

    @Override
    public CustomerDTO bffSaveCustomer(CustomerDTO customerDTO) {
        return bffCustomerRestPort.bffSaveCustomer(customerDTO);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return bffCustomerRestPort.getAllCustomers();
    }

    @Override
    public void deleteCustomerByDocumentNumber(String documentNumber) {
        bffCustomerRestPort.deleteCustomerByDocumentNumber(documentNumber);
    }
}
