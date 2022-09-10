package com.hopsoft.brew.ingredients.repository;

import com.hopsoft.brew.ingredients.domain.Hop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "hops", path = "hops")
public interface HopRepository extends MongoRepository<Hop, String> {
}
