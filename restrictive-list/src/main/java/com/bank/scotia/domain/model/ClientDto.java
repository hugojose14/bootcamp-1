package com.bank.scotia.domain.model;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {
    private String documentType;
    private String documentNumber;
    private String name;
    private String lastName;
    private LocalDate documentIssueDate;
    private LocalDate birthDate;
    private String email;
    private String cellPhone;
}
