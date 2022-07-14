package com.accenture.codewhisperers.poc;

import com.accenture.codewhisperers.poc.repositories.POCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PocApplication {

	@Autowired
	POCRepo pocRepo;

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

}
