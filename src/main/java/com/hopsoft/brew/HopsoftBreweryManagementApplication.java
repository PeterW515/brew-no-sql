package com.hopsoft.brew;

import com.hopsoft.brew.brew.BrewingRunRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HopsoftBreweryManagementApplication {


	public static void main(String[] args) {
		SpringApplication.run(HopsoftBreweryManagementApplication.class, args);
	}


}
