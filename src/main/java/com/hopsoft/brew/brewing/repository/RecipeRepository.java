package com.hopsoft.brew.brewing.repository;

import com.hopsoft.brew.brewing.domain.Recipe;
import com.hopsoft.brew.ingredients.domain.WaterProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "recipes", path = "recipes", excerptProjection = InlineWaterProfile.class)
public interface RecipeRepository extends MongoRepository<Recipe, String> {
}

@Projection(name="inlineWaterProfile",types = WaterProfile.class)
interface InlineWaterProfile{
    String getName();

    Collection<WaterProfile> getWaterProfiles();
}