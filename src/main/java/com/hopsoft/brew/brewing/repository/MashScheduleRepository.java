package com.hopsoft.brew.brewing.repository;

import com.hopsoft.brew.brewing.domain.MashSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "mashSchedules", path = "mashSchedules")
public interface MashScheduleRepository extends MongoRepository<MashSchedule, String> {
}