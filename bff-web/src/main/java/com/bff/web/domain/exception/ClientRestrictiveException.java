package com.bff.web.domain.exception;

public class ClientRestrictiveException extends RuntimeException{
    public ClientRestrictiveException(String message){
        super(message);
    }
}
