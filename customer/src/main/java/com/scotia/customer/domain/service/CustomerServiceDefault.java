package com.scotia.customer.domain.service;

import com.scotia.customer.domain.data.CustomerDTO;
import com.scotia.customer.domain.exception.CustomerNotFoundException;
import com.scotia.customer.domain.exception.DuplicateCustomerException;
import com.scotia.customer.domain.exception.ExceptionCode;
import com.scotia.customer.domain.ports.api.CustomerServicePort;
import com.scotia.customer.domain.ports.persistence.CustomerPersistencePort;

import java.util.List;

public class CustomerServiceDefault implements CustomerServicePort {

    private final CustomerPersistencePort customerPersistencePort;

    public CustomerServiceDefault(CustomerPersistencePort customerPersistencePort){
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        return customerPersistencePort.getCustomers();
    }

    @Override
    public void deleteCustomerByDocumentNumber(String documentNumber) {

        if(!getCustomerFindByDocumentNumber(documentNumber)){
            throw new CustomerNotFoundException(ExceptionCode.CUSTOMER_NOT_FOUND.getDescription());
        }

        customerPersistencePort.deleteCustomerByDocumentNumber(documentNumber);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {

        if(getCustomerFindByDocumentNumber(customerDTO.getDocumentNumber())){
             throw new DuplicateCustomerException(ExceptionCode.DUPLICATE_CUSTOMER.getDescription());
        }
        return customerPersistencePort.saveCustomer(customerDTO);
    }

    @Override
    public Boolean getCustomerFindByDocumentNumber(String documentNumber) {
        return customerPersistencePort.getCustomerFindByDocumentNumber(documentNumber);
    }
}
