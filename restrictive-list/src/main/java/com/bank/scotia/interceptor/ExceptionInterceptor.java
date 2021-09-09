package com.bank.scotia.interceptor;

import com.bank.scotia.domain.exceptions.UnauthorizedErrorException;
import com.bank.scotia.domain.model.ResponseError;
import com.bank.scotia.domain.exceptions.ClientRestrictiveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClientRestrictiveException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseError> clientRestrictiveException(
            ClientRestrictiveException clientRestrictiveException) {
        ResponseError errorResponse =
                new ResponseError(clientRestrictiveException.getMessage(), "E001");
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedErrorException.class)
    public ResponseEntity<ResponseError> unauthorizedErrorException(
            UnauthorizedErrorException unauthorizedErrorException) {
        ResponseError errorResponse =
                new ResponseError(unauthorizedErrorException.getMessage(), "E002");
        return new ResponseEntity<>(errorResponse,HttpStatus.UNAUTHORIZED);
    }



}