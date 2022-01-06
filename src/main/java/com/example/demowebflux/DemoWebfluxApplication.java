package com.example.demowebflux;

import com.example.demowebflux.domain.Customer;
import com.example.demowebflux.repository.CustomerRepository;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.time.Duration;
import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class DemoWebfluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoWebfluxApplication.class, args);
    }
}

