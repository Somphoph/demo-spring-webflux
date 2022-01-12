package com.example.demowebflux.service;

import com.example.demowebflux.domain.Customer;
import reactor.core.publisher.Flux;

public interface CustomerService {
    Flux<Customer> performTest();
}
