package com.hopsoft.brew.ingredients.service.impl;

import com.hopsoft.brew.ingredients.domain.WaterProfile;
import com.hopsoft.brew.ingredients.repository.WaterProfileRepository;
import com.hopsoft.brew.ingredients.service.api.WaterProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaterProfileServiceImpl implements WaterProfileService {

    @Autowired
    WaterProfileRepository waterProfileRepository;

    @Override
    public WaterProfile saveWaterProfile(WaterProfile waterProfile) {
        return waterProfileRepository.save(waterProfile);
    }

    @Override
    public Optional<WaterProfile> findByWaterProfileId(String waterProfileId) {
        return waterProfileRepository.findById(waterProfileId);
    }

    @Override
    public void deleteByWaterProfileId(String waterProfileId) {
        waterProfileRepository.deleteById(waterProfileId);
    }

    @Override
    public void updateWaterProfile(WaterProfile waterProfile) {
        waterProfileRepository.save(waterProfile);
    }

    @Override
    public boolean waterProfileExists(WaterProfile waterProfile) {
        return waterProfileRepository.exists(Example.of(waterProfile));
    }

    @Override
    public List<WaterProfile> findAll() {
        return waterProfileRepository.findAll();
    }

    @Override
    public void deleteAll() {
        waterProfileRepository.deleteAll();
    }
}
