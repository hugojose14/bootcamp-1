package com.scotia.customer.infrastructure.mappers;


import com.scotia.customer.domain.data.CustomerDTO;
import com.scotia.customer.infrastructure.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDTO customerDTO);
    List<Customer> customersDtoToCustomers(List<CustomerDTO> customersDto);
    List<CustomerDTO> customersToCustomersDto(List<Customer> customers);

}
