package com.scotia.customer.infrastructure.error;

import com.scotia.customer.domain.data.ResponseError;
import com.scotia.customer.domain.exception.CustomerNotFoundException;
import com.scotia.customer.domain.exception.DuplicateCustomerException;
import com.scotia.customer.domain.exception.ExceptionCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateCustomerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseError> duplicateCustomerException(
            DuplicateCustomerException clientRestrictiveException) {

        ResponseError errorResponse =
                new ResponseError(clientRestrictiveException.getMessage(), ExceptionCode.DUPLICATE_CUSTOMER.getCode());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseError>customerNotFoundException(
            CustomerNotFoundException customerNotFoundException) {

        ResponseError errorResponse =
                new ResponseError(customerNotFoundException.getMessage(), ExceptionCode.CUSTOMER_NOT_FOUND.getCode());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);

    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).collect(Collectors.toList());
        ResponseError responseError =
                new ResponseError(ExceptionCode.ARGUMENT_NOT_VALID.getDescription(),
                        ExceptionCode.ARGUMENT_NOT_VALID.getCode(), errors);
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }


}
