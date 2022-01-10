package com.example.demowebmvc.controller;

import com.example.demowebmvc.domain.Customer;
import com.example.demowebmvc.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/customers")
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }
    @GetMapping
    private Iterable<Customer> getCustomers() throws InterruptedException {
        Thread.sleep(1000);
        return customerRepository.findAll();
    }
}
