package com.hopsoft.brew.brewing.repository;

import com.hopsoft.brew.brewing.domain.UnitOfMeasure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "unitsOfMeasure", path = "unitsOfMeasure")
public interface UnitOfMeasureRepository extends MongoRepository<UnitOfMeasure, String> {
}