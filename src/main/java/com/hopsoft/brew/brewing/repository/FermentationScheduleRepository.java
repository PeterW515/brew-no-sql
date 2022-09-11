package com.hopsoft.brew.brewing.repository;

import com.hopsoft.brew.brewing.domain.FermentationSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "fermentationSchedules", path = "fermentationSchedules")
public interface FermentationScheduleRepository extends MongoRepository<FermentationSchedule, String> {
}