package com.hopsoft.brew.ingredients.repository;

import com.hopsoft.brew.ingredients.domain.Malt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "malts", path = "malts")
public interface MaltRepository extends MongoRepository<Malt, String> {
}
