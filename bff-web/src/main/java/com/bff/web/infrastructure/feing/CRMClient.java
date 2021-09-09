package com.bff.web.infrastructure.feing;

import com.bff.web.domain.data.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "crm-integration", url = "${url.component.crm}")
public interface CRMClient {

    @RequestMapping(method = RequestMethod.GET, value = "/customers",produces = "application/json")
    List<CustomerDTO> getCustomers();

    @RequestMapping(method = RequestMethod.POST, value="/customers",produces = "application/json")
    CustomerDTO saveCustomers(CustomerDTO customerDTO);

    @RequestMapping(method = RequestMethod.DELETE, value = "/customer/{documentNumber}")
    void deleteCustomerByDocumentNumber(@PathVariable("documentNumber") String documentNumber);
}
