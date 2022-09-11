package com.hopsoft.brew.brewing.repository;

import com.hopsoft.brew.brewing.domain.YeastLine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "yeastLines", path = "yeastLines")
public interface YeastLineRepository extends MongoRepository<YeastLine, String> {
}