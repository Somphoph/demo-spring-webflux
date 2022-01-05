package com.example.demowebflux.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Data
public class Customer {
    @Id
    private String cif;
    private String firstName;
    private String lastName;
}
