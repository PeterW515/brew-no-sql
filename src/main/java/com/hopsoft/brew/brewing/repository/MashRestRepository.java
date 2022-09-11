package com.hopsoft.brew.brewing.repository;

import com.hopsoft.brew.brewing.domain.MashRest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "mashRests", path = "mashRests")
public interface MashRestRepository extends MongoRepository<MashRest, String> {
}