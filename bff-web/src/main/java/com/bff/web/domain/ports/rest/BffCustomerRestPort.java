package com.bff.web.domain.ports.rest;

import com.bff.web.domain.data.CustomerDTO;

import java.util.List;


public interface BffCustomerRestPort {
    CustomerDTO bffSaveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    void deleteCustomerByDocumentNumber(String documentNumber);
}
