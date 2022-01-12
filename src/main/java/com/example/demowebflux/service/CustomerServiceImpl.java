package com.example.demowebflux.service;

import com.example.demowebflux.domain.Customer;
import com.example.demowebflux.domain.CustomerHist;
import com.example.demowebflux.repository.CustomerHistRepository;
import com.example.demowebflux.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerHistRepository customerHistRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerHistRepository customerHistRepository) {
        this.customerRepository = customerRepository;
        this.customerHistRepository = customerHistRepository;
    }

    @Override
    public Flux<Customer> performTest() {
        this.findAll().subscribe(customer -> {
            if (customer.getFirstName().contains("_Test")) {
                customer.setFirstName(customer.getFirstName().replace("_Test", ""));

            } else {
                customer.setFirstName(customer.getFirstName() + "_Test");
            }
            try {
                save(customer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                saveHist(customer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return this.findAll();
    }

    public Flux<Customer> findAll()  {

        return customerRepository.findAll();
    }

    public Mono<Customer> save(Customer customer) throws InterruptedException {
        Thread.sleep(1000);
        return customerRepository.save(customer);
    }

    public Mono<CustomerHist> saveHist(Customer customer) throws InterruptedException {
        Thread.sleep(1000);
        CustomerHist hist = new CustomerHist();
        hist.setDatetime(new Date());
        hist.setId(customer.getId());
        hist.setFirstName(customer.getFirstName());
        hist.setLastName(customer.getLastName());
        return customerHistRepository.save(hist);
    }
}
