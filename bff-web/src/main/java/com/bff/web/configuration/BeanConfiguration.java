package com.bff.web.configuration;

import com.bff.web.domain.ports.api.BFfRestrictiveListServicePort;
import com.bff.web.domain.ports.api.BffCustomerServicePort;
import com.bff.web.domain.ports.rest.BffCustomerRestPort;
import com.bff.web.domain.ports.rest.BffRestrictiveListRestPort;
import com.bff.web.domain.service.BffCustomerService;
import com.bff.web.domain.service.BffRestrictiveListService;
import com.bff.web.infrastructure.adapter.BffCustomerAdapter;
import com.bff.web.infrastructure.adapter.BffRestrictiveListAdapter;
import com.bff.web.infrastructure.feing.CRMClient;
import com.bff.web.infrastructure.feing.RestrictiveListClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final CRMClient crmClient;
    private final RestrictiveListClient restrictiveListClient;

    public BeanConfiguration(CRMClient crmClient,
                             RestrictiveListClient restrictiveListClient){
        this.crmClient = crmClient;
        this.restrictiveListClient = restrictiveListClient;
    }
    @Bean
    public BffCustomerRestPort customerRequestPort(){
        return new BffCustomerAdapter(crmClient);
    }

    @Bean
    public BffCustomerServicePort customerService(){
        return new BffCustomerService(customerRequestPort());
    }

    @Bean
    public BffRestrictiveListRestPort restrictiveListRestPort(){
        return new BffRestrictiveListAdapter(restrictiveListClient);
    }

    @Bean
    public BFfRestrictiveListServicePort restrictiveListServicePort (){
        return new BffRestrictiveListService(restrictiveListRestPort());
    }

}
