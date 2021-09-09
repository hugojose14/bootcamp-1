package com.scotia.customer.configuration;

import com.scotia.customer.domain.ports.api.CustomerServicePort;
import com.scotia.customer.domain.ports.persistence.CustomerPersistencePort;
import com.scotia.customer.domain.service.CustomerServiceDefault;
import com.scotia.customer.infrastructure.adapter.CustomerAdapter;
import com.scotia.customer.infrastructure.mappers.CustomerMapper;
import com.scotia.customer.infrastructure.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerConfig(CustomerRepository customerRepository,CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Bean
    public CustomerPersistencePort customerPersistencePort(){
        return new CustomerAdapter(customerRepository,customerMapper);
    }

    @Bean
    public CustomerServicePort customerService(){
        return new CustomerServiceDefault(customerPersistencePort());
    }

}
