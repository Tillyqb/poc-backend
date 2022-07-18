package com.accenture.codewhisperers.poc;

import com.accenture.codewhisperers.poc.repositories.POCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

}
