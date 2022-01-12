package com.example.demowebflux.repository;

import com.example.demowebflux.domain.CustomerHist;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerHistRepository extends ReactiveCrudRepository<CustomerHist, Integer> {
}
