package com.hopsoft.brew;

import com.hopsoft.brew.brewing.domain.*;
import com.hopsoft.brew.brewing.enums.*;
import com.hopsoft.brew.brewing.repository.*;
import com.hopsoft.brew.ingredients.domain.Hop;
import com.hopsoft.brew.ingredients.domain.Malt;
import com.hopsoft.brew.ingredients.domain.WaterProfile;
import com.hopsoft.brew.ingredients.enums.HopPurpose;
import com.hopsoft.brew.ingredients.enums.Level;
import com.hopsoft.brew.ingredients.enums.YeastForm;
import com.hopsoft.brew.ingredients.enums.YeastType;
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

import java.util.*;

@SpringBootApplication
@ComponentScan
@EnableMongoRepositories
public class HopsoftBreweryManagementApplication {
	private static final Logger logger = LoggerFactory.getLogger(HopsoftBreweryManagementApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(HopsoftBreweryManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(HopRepository hopRepository, YeastRepository yeastRepository,
								  MaltRepository maltRepository,
								  WaterProfileRepository waterProfileRepository,
								  FermentationScheduleRepository fermentationScheduleRepository, MashScheduleRepository mashScheduleRepository,
								  HopLineRepository hopLineRepository, MaltLineRepository maltLineRepository,
								  MashRestRepository mashRestRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository,
								  YeastLineRepository yeastLineRepository){
		return (args) -> {
			hopRepository.deleteAll();
			yeastRepository.deleteAll();
			maltRepository.deleteAll();
			waterProfileRepository.deleteAll();
			fermentationScheduleRepository.deleteAll();
			mashScheduleRepository.deleteAll();
			hopLineRepository.deleteAll();
			mashRestRepository.deleteAll();
			yeastLineRepository.deleteAll();
			maltLineRepository.deleteAll();
			recipeRepository.deleteAll();
			unitOfMeasureRepository.deleteAll();

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
			Hop firstHop = hopRepository.save(new Hop("Citra", 10,15,12.5,HopPurpose.DUAL,false,27,flavorProfile1));

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
			Hop secondHop = hopRepository.save(new Hop("Saaz",2,5,3.5, HopPurpose.AROMA,true,50,flavorProfile2));

			Yeast firstYeast = yeastRepository.save(new Yeast("Muntons", Level.MEDIUM,Level.HIGH, YeastForm.DRY, YeastType.ALE,8.0,72.0,75.0,73.5,64.0,70.0,67.0));
			Yeast secondYeast = yeastRepository.save(new Yeast("American Lager", Level.HIGH,Level.MEDIUM,YeastForm.LIQUID,YeastType.LAGER,null,79.0,83.0,81.0,48.0,56.0,52.0));


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

			WaterProfile firstWaterProfile = waterProfileRepository.save(new WaterProfile("London Water Profile", 52.0,32.0,104.0,32.0,86.0,34.0,6.0));
			WaterProfile secondWaterProfile = waterProfileRepository.save(new WaterProfile("Dublin Water Profile",118.0,4.0,319.0,54.0,12.0,19.0,5.9));

			UnitOfMeasure lbs = unitOfMeasureRepository.save(new UnitOfMeasure("Pounds"));
			UnitOfMeasure oz = unitOfMeasureRepository.save(new UnitOfMeasure("Ounces"));
			UnitOfMeasure pkg = unitOfMeasureRepository.save(new UnitOfMeasure("Package"));

			MaltLine maltLineOne = maltLineRepository.save(new MaltLine(1,firstMalt,6.0 ,lbs));
			List<MaltLine> maltLines = new ArrayList<>();
			maltLines.add(maltLineOne);

			HopLine hopLine = hopLineRepository.save(new HopLine(1,firstHop,0.5,oz,60.0,50.0));
			List<HopLine> hopLines = new ArrayList<>();
			hopLines.add(hopLine);

			FermentationSchedule fermentationSchedule = fermentationScheduleRepository.save(new FermentationSchedule(10.0, 60.0, 70.0, 65.0, Stage.PRIMARY_FERMENTER));
			YeastLine yeastLine = yeastLineRepository.save(new YeastLine(1, firstYeast, 1.0, pkg, fermentationSchedule));
			List<YeastLine> yeastLines = new ArrayList<>();
			yeastLines.add(yeastLine);

			MashRest mashRest = mashRestRepository.save(new MashRest(RestType.CONVERSION, 150.0, 60.0));
			List<MashRest> mashRests = new ArrayList<>();
			mashRests.add(mashRest);

			Date startDate = new Date();

			MashSchedule mashSchedule = mashScheduleRepository.save(new MashSchedule(InfusionType.SINGLE_TEMP_INFUSION,mashRests));
			Recipe recipe = recipeRepository.save(new Recipe("Three Weisse Guys", Style.AMERICAN_WHEAT, 1.040,1.055,1.047,10.0,13.5,11.75,1.008,
					1.013,1.010,10.0,30.0,20.0,4.5,6.0,3.0,maltLines,
					hopLines,yeastLines,firstWaterProfile, Status.NOT_STARTED,mashSchedule,startDate,null));


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
