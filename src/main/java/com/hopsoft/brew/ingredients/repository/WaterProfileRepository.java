package com.hopsoft.brew.ingredients.repository;

import com.hopsoft.brew.ingredients.domain.WaterProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "waterProfiles", path = "waterProfiles")
public interface WaterProfileRepository extends MongoRepository<WaterProfile, String> {
}
