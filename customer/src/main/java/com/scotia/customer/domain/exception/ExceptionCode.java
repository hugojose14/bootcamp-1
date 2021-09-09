package com.scotia.customer.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionCode {

    DUPLICATE_CUSTOMER("E001", "Duplicate customer"),
    ARGUMENT_NOT_VALID("E002", "Argument not valid"),
    CUSTOMER_NOT_FOUND("E003", "Customer not found");

    private String code;
    private String description;

}
