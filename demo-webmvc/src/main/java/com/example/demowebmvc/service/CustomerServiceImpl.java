package com.example.demowebmvc.service;

import com.example.demowebmvc.domain.Customer;
import com.example.demowebmvc.domain.CustomerHist;
import com.example.demowebmvc.repository.CustomerHistRepository;
import com.example.demowebmvc.repository.CustomerRepository;
import org.springframework.stereotype.Service;

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
    public Iterable<Customer> performTest() {
        Iterable<Customer> list = this.findAll();
        for (Customer customer : list) {
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
        }
        return this.findAll();
    }

    public Iterable<Customer> findAll()  {

        return customerRepository.findAll();
    }

    public Customer save(Customer customer) throws InterruptedException {
        Thread.sleep(1000);
        return customerRepository.save(customer);
    }

    public CustomerHist saveHist(Customer customer) throws InterruptedException {
        Thread.sleep(1000);
        CustomerHist hist = new CustomerHist();
        hist.setDatetime(new Date());
        hist.setCustomerId(customer.getId());
        hist.setFirstName(customer.getFirstName());
        hist.setLastName(customer.getLastName());
        return customerHistRepository.save(hist);
    }
}
