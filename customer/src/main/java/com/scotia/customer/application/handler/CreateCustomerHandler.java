package com.scotia.customer.application.handler;

import com.scotia.customer.application.factory.FactoryCustomer;
import com.scotia.customer.domain.data.CustomerDTO;
import com.scotia.customer.domain.ports.api.CustomerServicePort;
import com.scotia.customer.application.command.CustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerHandler implements CommandHandlerResponse<CustomerRequest, CustomerDTO>{

    private final FactoryCustomer factoryCustomer;
    private final CustomerServicePort customerServicePort;

    public CreateCustomerHandler( FactoryCustomer factoryCustomer,
             CustomerServicePort customerServicePort){
        this.factoryCustomer = factoryCustomer;
        this.customerServicePort = customerServicePort;
    }

    @Override
    public CustomerDTO execute(CustomerRequest customerRequest){
        CustomerDTO customerDTO = factoryCustomer.create(customerRequest);
        return (this.customerServicePort.saveCustomer(customerDTO));
    }
}
