package com.kenzie.appserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class Application {

    //entry point for the Spring Boot application

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
