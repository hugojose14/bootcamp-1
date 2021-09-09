package com.bank.scotia.domain.ports;

import com.bank.scotia.domain.model.ClientDto;
import com.bank.scotia.domain.model.ClientRequest;

public interface ClientService {
    ClientDto validateClientInformation(ClientRequest clientRequest);
}
