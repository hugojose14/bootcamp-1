package com.scotia.customer.domain.ports.api;

import com.scotia.customer.domain.data.CustomerDTO;

import java.util.List;

public interface CustomerServicePort {
    List<CustomerDTO> getCustomers();
    void deleteCustomerByDocumentNumber(String documentNumber);
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    Boolean getCustomerFindByDocumentNumber(String documentNumber);
}
