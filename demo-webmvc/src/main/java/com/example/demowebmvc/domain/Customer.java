package com.example.demowebmvc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Data
public class Customer {

    @Id
    private int id;
    private String firstName;
    private String lastName;
}
