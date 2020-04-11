package com.example.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
@EnableCaching
public class EmployeeApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EmployeeApplication.class, args); 
    }
}
