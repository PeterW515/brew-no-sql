package com.hopsoft.brew.ingredients.repository;

import com.hopsoft.brew.ingredients.domain.Yeast;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "yeast", path = "yeast")
public interface YeastRepository extends MongoRepository<Yeast,String> {
}
