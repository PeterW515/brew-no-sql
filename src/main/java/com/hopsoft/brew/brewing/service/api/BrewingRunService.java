package com.hopsoft.brew.brewing.service.api;

import com.hopsoft.brew.brewing.domain.BrewingRun;

import java.util.List;
import java.util.Optional;

public interface BrewingRunService {
    BrewingRun saveBrewingRun(BrewingRun brewingRun);

    Optional<BrewingRun> findByBrewingRunId(String brewingRunId);

    void deleteByBrewingRunId(String brewingRunId);

    void updateBrewingRun(BrewingRun brewingRun);

    boolean brewingRunExists(BrewingRun brewingRun);

    List<BrewingRun> findAll();

    void deleteAll();
}
