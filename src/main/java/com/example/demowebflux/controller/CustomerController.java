package com.example.demowebflux.controller;

import com.example.demowebflux.domain.Customer;
import com.example.demowebflux.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Slf4j
@RequestMapping("/customer")
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @GetMapping("/{id}")
    private Mono<Customer> getCustomerById(@PathVariable int id) {
        log.info("get by id > {}", id);
        return customerRepository.findById(id);
    }
}
