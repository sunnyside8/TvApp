package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication
@EnableMongoRepositories(basePackages = {"org.example.*"})
@ComponentScan(basePackages = {"org.example.*"})
@EntityScan(basePackages = {"org.example.*"})
public class TvApp {
    public static void main(String[] args) {
        SpringApplication.run(TvApp.class);
    }
}