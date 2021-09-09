package com.scotia.customer.application.factory;

import com.scotia.customer.domain.data.CustomerDTO;
import com.scotia.customer.application.command.CustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class FactoryCustomer {

    public CustomerDTO create(CustomerRequest customerRequest){
        return CustomerDTO.builder().name(customerRequest.getName())
                .lastName(customerRequest.getLastName())
                .documentNumber(customerRequest.getDocumentNumber())
                .documentType(customerRequest.getDocumentType())
                .birthDate(customerRequest.getBirthDate())
                .email(customerRequest.getEmail())
                .cellPhone(customerRequest.getCellPhone())
                .documentIssueDate(customerRequest.getDocumentIssueDate()).build();
    }
}
