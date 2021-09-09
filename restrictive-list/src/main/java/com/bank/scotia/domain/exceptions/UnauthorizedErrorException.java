package com.bank.scotia.domain.exceptions;

public class UnauthorizedErrorException extends RuntimeException{
    private static final long serialVersionUID = 1483002602935301959L;
    public UnauthorizedErrorException(String message) {
        super(message);
    }
}
