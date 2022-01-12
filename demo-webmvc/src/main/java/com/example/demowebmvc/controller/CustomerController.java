package com.example.demowebmvc.controller;

import com.example.demowebmvc.domain.Customer;
import com.example.demowebmvc.repository.CustomerRepository;
import com.example.demowebmvc.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    private Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/perform")
    private Iterable<Customer> fluxPerformTest(){
        return customerService.performTest();
    }
}
