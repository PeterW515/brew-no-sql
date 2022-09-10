package com.hopsoft.brew;

import com.hopsoft.brew.ingredients.domain.Hop;
import com.hopsoft.brew.ingredients.domain.Malt;
import com.hopsoft.brew.ingredients.domain.WaterProfile;
import com.hopsoft.brew.ingredients.repository.HopRepository;
import com.hopsoft.brew.ingredients.domain.Yeast;
import com.hopsoft.brew.ingredients.repository.MaltRepository;
import com.hopsoft.brew.ingredients.repository.WaterProfileRepository;
import com.hopsoft.brew.ingredients.repository.YeastRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan
@EnableMongoRepositories
public class HopsoftBreweryManagementApplication {
	private static final Logger logger = LoggerFactory.getLogger(HopsoftBreweryManagementApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(HopsoftBreweryManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(HopRepository hopRepository, YeastRepository yeastRepository, MaltRepository maltRepository, WaterProfileRepository waterProfileRepository){
		return (args) -> {
			hopRepository.deleteAll();
			yeastRepository.deleteAll();
			maltRepository.deleteAll();

			Map<String,Double> flavorProfile1 = new HashMap<>();
			flavorProfile1.put("Citrus",5.0);
			flavorProfile1.put("Tropical Fruit",4.0);
			flavorProfile1.put("Stone Fruit",1.0);
			flavorProfile1.put("Berry",0.0);
			flavorProfile1.put("Floral",1.0);
			flavorProfile1.put("Grassy",0.0);
			flavorProfile1.put("Herbal",0.0);
			flavorProfile1.put("Spice",2.0);
			flavorProfile1.put("Resin/Pine",2.0);
			Hop firstHop = hopRepository.save(new Hop("Citra", 10,15,12.5,"Dual",false,27,flavorProfile1));

			Map<String,Double> flavorProfile2 = new HashMap<>();
			flavorProfile2.put("Citrus",3.0);
			flavorProfile2.put("Tropical Fruit",0.0);
			flavorProfile2.put("Stone Fruit",0.0);
			flavorProfile2.put("Berry",0.0);
			flavorProfile2.put("Floral",2.0);
			flavorProfile2.put("Grassy",0.0);
			flavorProfile2.put("Herbal",0.0);
			flavorProfile2.put("Spice",4.0);
			flavorProfile2.put("Resin/Pine",4.0);
			Hop secondHop = hopRepository.save(new Hop("Saaz",2,5,3.5,"Aroma",true,50,flavorProfile2));

			Yeast firstYeast = yeastRepository.save(new Yeast("Muntons", "Medium","High","Dry","Ale",8.0,72.0,75.0,73.5,64.0,70.0,67.0));
			Yeast secondYeast = yeastRepository.save(new Yeast("American Lager", "High","Medium","Liquid","Lager",null,79.0,83.0,81.0,48.0,56.0,52.0));


			Malt firstMalt = new Malt.MaltBuilder("Two-Row Lager Malt")
					.setMealy(98.0)
					.setHalf(2.0)
					.setGlassy(0.0)
					.setSizeSevenSixtyFourths(60.0)
					.setSizeSixSixtyFourths(20.0)
					.setSizeThru(2.0)
					.setPercentMoisture(4.0)
					.setPercentExtractFineGrindDryBasis(80.5)
					.setPercentExtractCoarseGrindDryBasis(79.5)
					.setFineCoarseDifference(1.0)
					.setProtein(12.0)
					.setSolubleToTotalProteinRatio(42.0)
					.setDiastaticPower(140.0)
					.setColor(1.8)
					.setGrainType("Barley")
					.setMaltType("Base")
					.build();

			Malt secondMalt = new Malt.MaltBuilder("Munich Malt")
					.setMealy(95.0)
					.setHalf(5.0)
					.setGlassy(0.0)
					.setSizeSevenSixtyFourths(55.0)
					.setSizeSixSixtyFourths(25.0)
					.setSizeThru(2.0)
					.setPercentMoisture(3.3)
					.setPercentExtractFineGrindDryBasis(78.0)
					.setPercentExtractCoarseGrindDryBasis(76.0)
					.setFineCoarseDifference(2.0)
					.setProtein(11.7)
					.setSolubleToTotalProteinRatio(38.0)
					.setDiastaticPower(40.0)
					.setColor(10.0)
					.setGrainType("Barley")
					.setMaltType("Kilned")
					.build();

			maltRepository.save(firstMalt);
			maltRepository.save(secondMalt);

			WaterProfile firstWaterProfile = waterProfileRepository.save(new WaterProfile());
			WaterProfile secondWaterProfile = waterProfileRepository.save(new WaterProfile());



			for(Hop hop: hopRepository.findAll()){
				logger.info("Hop: " + hop);
			}
			for(Yeast yeast: yeastRepository.findAll()){
				logger.info("Yeast: " + yeast);
			}
			for(Malt malt: maltRepository.findAll()){
				logger.info("Malt: " + malt);
			}
			for(WaterProfile waterProfile: waterProfileRepository.findAll()){
				logger.info("WaterProfile: " + waterProfile);
			}
		};
	}
}
