package com.hopsoft.brew;

import com.hopsoft.brew.ingredients.domain.Hop;
import com.hopsoft.brew.ingredients.repository.HopRepository;
import com.hopsoft.brew.ingredients.domain.Yeast;
import com.hopsoft.brew.ingredients.repository.YeastRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan
@EnableMongoRepositories
public class HopsoftBreweryManagementApplication {
	private static final Logger logger = LoggerFactory.getLogger(HopsoftBreweryManagementApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(HopsoftBreweryManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(HopRepository hopRepository, YeastRepository yeastRepository){
		return (args) -> {
			hopRepository.deleteAll();
			yeastRepository.deleteAll();
			Hop firstHop = hopRepository.save(new Hop("Brewers Gold", 9, "Bittering", false));
			Hop secondHop = hopRepository.save(new Hop("Chinook", 13, "Bittering", false));

			Yeast firstYeast = yeastRepository.save(new Yeast("Coopers","Medium","Medium","Dry","Ale"));
			Yeast secondYeast = yeastRepository.save(new Yeast("Muntons","Medium","High","Dry","Ale"));

			for(Hop hop: hopRepository.findAll()){
				logger.info("Hop: " + hop);
			}
			for(Yeast yeast: yeastRepository.findAll()){
				logger.info("Yeast: " + yeast);
			}
		};
	}
}
