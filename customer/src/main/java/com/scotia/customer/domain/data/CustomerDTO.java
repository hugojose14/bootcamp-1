package com.scotia.customer.domain.data;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private String documentType;
    private String documentNumber;
    private String name;
    private String lastName;
    private LocalDate documentIssueDate;
    private LocalDate birthDate;
    private String email;
    private String cellPhone;
}

