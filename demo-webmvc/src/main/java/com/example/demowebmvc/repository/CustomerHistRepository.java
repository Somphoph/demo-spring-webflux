package com.example.demowebmvc.repository;

import com.example.demowebmvc.domain.CustomerHist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerHistRepository extends CrudRepository<CustomerHist, Integer> {
}
