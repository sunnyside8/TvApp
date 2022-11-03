package com.example.tvservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class TvServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TvServiceApplication.class, args);
	}

}
