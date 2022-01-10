package com.example.demowebflux.controller;

import com.example.demowebflux.domain.Customer;
import com.example.demowebflux.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("/customers")
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @GetMapping("/{id}")
    private Mono<Customer> getCustomerById(@PathVariable int id) {
        return customerRepository.findById(id);
    }

    @GetMapping
    private Flux<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
