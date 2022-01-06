package com.example.demowebflux.controller;

import com.example.demowebflux.domain.Customer;
import com.example.demowebflux.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CustomerController.class)
@ContextConfiguration(classes = {CustomerRepository.class})
class CustomerControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    public void getCustomerByCif() {
        webClient.get().uri("http://localhost:8080/customer/{cif}", "1").exchange().expectStatus().isOk().expectBody(Customer.class);
    }
}
