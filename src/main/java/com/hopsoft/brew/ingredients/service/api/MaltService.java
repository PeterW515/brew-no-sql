package com.hopsoft.brew.ingredients.service.api;

import com.hopsoft.brew.ingredients.domain.Malt;

import java.util.List;
import java.util.Optional;

public interface MaltService {
    Malt saveMalt(Malt malt);
    Optional<Malt> findByMaltId(String maltId);
    void deleteByMaltId(String maltId);
    void updateMalt(Malt malt);
    boolean maltExists(Malt malt);
    List<Malt> findAll();
    void deleteAll();
}
