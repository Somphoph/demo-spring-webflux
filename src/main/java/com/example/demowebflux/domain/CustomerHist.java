package com.example.demowebflux.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class CustomerHist {
    @Id
    private Integer gid;
    private Date datetime;
    private Integer id;
    private String firstName;
    private String lastName;
}
