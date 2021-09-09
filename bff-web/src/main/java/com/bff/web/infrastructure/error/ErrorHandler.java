package com.bff.web.infrastructure.error;

import com.bff.web.domain.data.ResponseError;
import com.bff.web.domain.exception.ClientRestrictiveException;
import com.bff.web.domain.exception.CustomerNotFoundException;
import com.bff.web.domain.exception.DuplicateCustomerException;
import com.bff.web.domain.exception.UnauthorizedErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DuplicateCustomerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseError>duplicateCustomerException(
            DuplicateCustomerException duplicateCustomerException) {
        ResponseError responseError =
                new ResponseError(duplicateCustomerException.getMessage(), "E001" );
        return new ResponseEntity<>(responseError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseError>customerNotFoundException(
            CustomerNotFoundException customerNotFoundException) {
        ResponseError responseError =
                new ResponseError(customerNotFoundException.getMessage(), "E002" );
        return new ResponseEntity<>(responseError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedErrorException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ResponseError>unauthorizedErrorException(
            UnauthorizedErrorException unauthorizedErrorException) {
        ResponseError responseError =
                new ResponseError(unauthorizedErrorException.getMessage(), "E003" );
        return new ResponseEntity<>(responseError,HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(ClientRestrictiveException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseError>clientRestrictiveException(
            ClientRestrictiveException clientRestrictiveException) {
        ResponseError responseError =
                new ResponseError(clientRestrictiveException.getMessage(), "E004");
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }
}
