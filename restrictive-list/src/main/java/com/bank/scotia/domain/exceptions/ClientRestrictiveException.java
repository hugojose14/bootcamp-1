package com.bank.scotia.domain.exceptions;

public class ClientRestrictiveException extends RuntimeException{
    private static final long serialVersionUID = 1483002602935301959L;
    public ClientRestrictiveException(String message) {
        super(message);
    }
}