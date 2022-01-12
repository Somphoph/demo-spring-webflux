package com.example.demowebflux.controller;

import com.example.demowebflux.domain.Customer;
import com.example.demowebflux.repository.CustomerRepository;
import com.example.demowebflux.service.CustomerService;
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
    private final CustomerService customerService;
    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {

        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    private Mono<Customer> getCustomerById(@PathVariable int id) {
        return customerRepository.findById(id);
    }

    @GetMapping
    private Flux<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    @GetMapping("/perform")
    private Flux<Customer> fluxPerformTest(){
        return customerService.performTest();
    }
}
