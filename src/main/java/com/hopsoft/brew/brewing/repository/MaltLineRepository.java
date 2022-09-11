package com.hopsoft.brew.brewing.repository;

import com.hopsoft.brew.brewing.domain.MaltLine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "maltLines", path = "maltLines")
public interface MaltLineRepository extends MongoRepository<MaltLine, String> {
}