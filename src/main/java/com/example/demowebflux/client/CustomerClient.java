package com.example.demowebflux.client;

import com.example.demowebflux.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
public class CustomerClient {
    public static void main(String[] args) throws InterruptedException {
        WebClient client = WebClient.create("http://localhost:8080");
        Mono<Customer> employeeMono = client.get()
                .uri("/customer/{cif}", "1")
                .retrieve()
                .bodyToMono(Customer.class);

        employeeMono.subscribe(customer -> log.info("Customer => {}", customer), error -> log.error("Error =>  ",error),() -> log.info("Complete"));
        Thread.sleep(60000);
    }
}
