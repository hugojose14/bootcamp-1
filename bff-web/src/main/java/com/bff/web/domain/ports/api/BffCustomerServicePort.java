package com.bff.web.domain.ports.api;

import com.bff.web.domain.data.CustomerDTO;

import java.util.List;

public interface BffCustomerServicePort {
    CustomerDTO bffSaveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    void deleteCustomerByDocumentNumber(String documentNumber);
}
