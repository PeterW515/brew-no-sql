package com.hopsoft.brew.brewing.repository;

import com.hopsoft.brew.brewing.domain.BrewingRun;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "brewingRuns", path = "brewingRuns")
public interface BrewingRunRepository extends MongoRepository<BrewingRun, String> {
}