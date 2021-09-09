package com.bff.web.infrastructure.adapter;

import com.bff.web.domain.data.CustomerDTO;
import com.bff.web.domain.exception.CustomerNotFoundException;
import com.bff.web.domain.exception.DuplicateCustomerException;
import com.bff.web.domain.ports.rest.BffCustomerRestPort;
import com.bff.web.infrastructure.feing.CRMClient;
import feign.FeignException;

import java.util.List;

public class BffCustomerAdapter implements BffCustomerRestPort {

    private final CRMClient crmClient;

    public BffCustomerAdapter(CRMClient crmClient){
        this.crmClient = crmClient;
    }

    @Override
    public CustomerDTO bffSaveCustomer(CustomerDTO customerDTO) {
        try{
            return crmClient.saveCustomers(customerDTO);
        }catch (FeignException.BadRequest badRequestException){
            throw new DuplicateCustomerException("Duplicate customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return crmClient.getCustomers();
    }

    @Override
    public void deleteCustomerByDocumentNumber(String documentNumber) {
        try{
            crmClient.deleteCustomerByDocumentNumber(documentNumber);
        }
        catch (FeignException.NotFound notFoundException){
            throw  new CustomerNotFoundException("Customer not found");
        }
    }
}
