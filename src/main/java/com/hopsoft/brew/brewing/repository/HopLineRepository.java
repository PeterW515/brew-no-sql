package com.hopsoft.brew.brewing.repository;

import com.hopsoft.brew.brewing.domain.HopLine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "hopLines", path = "hopLines")
public interface HopLineRepository extends MongoRepository<HopLine, String> {
}