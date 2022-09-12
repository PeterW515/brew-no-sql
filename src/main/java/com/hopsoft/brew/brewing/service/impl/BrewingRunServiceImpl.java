package com.hopsoft.brew.brewing.service.impl;

import com.hopsoft.brew.brewing.domain.BrewingRun;
import com.hopsoft.brew.brewing.repository.BrewingRunRepository;
import com.hopsoft.brew.brewing.service.api.BrewingRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrewingRunServiceImpl implements BrewingRunService {

    @Autowired
    BrewingRunRepository brewingRunRepository;

    @Override
    public BrewingRun saveBrewingRun(BrewingRun brewingRun) {
        return brewingRunRepository.save(brewingRun);
    }

    @Override
    public Optional<BrewingRun> findByBrewingRunId(String brewingRunId) {
        return brewingRunRepository.findById(brewingRunId);
    }

    @Override
    public void deleteByBrewingRunId(String brewingRunId) {
        brewingRunRepository.deleteById(brewingRunId);
    }

    @Override
    public void updateBrewingRun(BrewingRun brewingRun) {
        brewingRunRepository.save(brewingRun);
    }

    @Override
    public boolean brewingRunExists(BrewingRun brewingRun) {
        return brewingRunRepository.exists(Example.of(brewingRun));
    }

    @Override
    public List<BrewingRun> findAll() {
        return brewingRunRepository.findAll();
    }

    @Override
    public void deleteAll() {
        brewingRunRepository.deleteAll();
    }
}
