package com.scotia.customer.infrastructure.adapter;

import com.scotia.customer.domain.data.CustomerDTO;
import com.scotia.customer.domain.ports.persistence.CustomerPersistencePort;
import com.scotia.customer.infrastructure.entity.Customer;
import com.scotia.customer.infrastructure.mappers.CustomerMapper;
import com.scotia.customer.infrastructure.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerAdapter implements CustomerPersistencePort {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerAdapter(CustomerRepository customerRepository,CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.customersToCustomersDto(customers);
    }

    @Override
    public void deleteCustomerByDocumentNumber(String documentNumber) {
        customerRepository.deleteById(documentNumber);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDto) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        Customer customerSaved = customerRepository.save(customer);
        return customerMapper.customerToCustomerDto(customerSaved);
    }

    @Override
    public Boolean getCustomerFindByDocumentNumber(String documentNumber) {
        Optional<Customer> customer = customerRepository.findById(documentNumber);
        if(customer.isPresent()){
            return true;
        }
        return false;
    }
}
