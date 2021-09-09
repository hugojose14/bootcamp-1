package com.bff.web.domain.exception;

public class UnauthorizedErrorException extends RuntimeException{

    public UnauthorizedErrorException(String message){
        super(message);
    }

}
