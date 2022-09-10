package com.hopsoft.brew.ingredients.service.api;

import com.hopsoft.brew.ingredients.domain.Hop;

import java.util.List;
import java.util.Optional;

public interface HopService {
    Hop saveHop(Hop hop);
    Optional<Hop> findByHopId(String hopId);
    void deleteByHopId(String hopId);
    void updateHop(Hop hop);
    boolean hopExists(Hop hop);
    List<Hop> findAll();
    void deleteAll();
}
