package com.example.demowebflux.controller;

import com.example.demowebflux.domain.Customer;
import com.example.demowebflux.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/{cif}")
    private Mono<Customer> getCustomerById(@PathVariable String cif){
        return customerRepository.findById(cif);
    }
}
