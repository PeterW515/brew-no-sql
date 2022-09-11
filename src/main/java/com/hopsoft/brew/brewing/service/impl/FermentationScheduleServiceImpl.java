package com.hopsoft.brew.brewing.service.impl;

import com.hopsoft.brew.brewing.domain.FermentationSchedule;
import com.hopsoft.brew.brewing.repository.FermentationScheduleRepository;
import com.hopsoft.brew.brewing.service.api.FermentationScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FermentationScheduleServiceImpl implements FermentationScheduleService {

    @Autowired
    FermentationScheduleRepository fermentationScheduleRepository;

    @Override
    public FermentationSchedule saveFermentationSchedule(FermentationSchedule fermentationSchedule) {
        return fermentationScheduleRepository.save(fermentationSchedule);
    }

    @Override
    public Optional<FermentationSchedule> findByFermentationScheduleId(String fermentationScheduleId) {
        return fermentationScheduleRepository.findById(fermentationScheduleId);
    }

    @Override
    public void deleteByFermentationScheduleId(String fermentationScheduleId) {
        fermentationScheduleRepository.deleteById(fermentationScheduleId);
    }

    @Override
    public void updateFermentationSchedule(FermentationSchedule fermentationSchedule) {
        fermentationScheduleRepository.save(fermentationSchedule);
    }

    @Override
    public boolean fermentationScheduleExists(FermentationSchedule fermentationSchedule) {
        return fermentationScheduleRepository.exists(Example.of(fermentationSchedule));
    }

    @Override
    public List<FermentationSchedule> findAll() {
        return fermentationScheduleRepository.findAll();
    }

    @Override
    public void deleteAll() {
        fermentationScheduleRepository.deleteAll();
    }
}
