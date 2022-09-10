package com.hopsoft.brew.ingredients;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "yeast", path = "yeast")
public interface YeastRepository extends MongoRepository<Yeast,String> {
}
