package com.scotia.customer.domain.ports.persistence;

import com.scotia.customer.domain.data.CustomerDTO;

import java.util.List;

public interface CustomerPersistencePort {
    List<CustomerDTO> getCustomers();
    void deleteCustomerByDocumentNumber(String documentNumber);
    CustomerDTO saveCustomer(CustomerDTO customer);
    Boolean getCustomerFindByDocumentNumber(String documentNumber);
}
