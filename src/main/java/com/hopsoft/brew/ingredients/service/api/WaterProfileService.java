package com.hopsoft.brew.ingredients.service.api;

import com.hopsoft.brew.ingredients.domain.WaterProfile;

import java.util.List;
import java.util.Optional;

public interface WaterProfileService {
    WaterProfile saveWaterProfile(WaterProfile waterProfile);
    Optional<WaterProfile> findByWaterProfileId(String waterProfileId);
    void deleteByWaterProfileId(String waterProfileId);
    void updateWaterProfile(WaterProfile waterProfile);
    boolean waterProfileExists(WaterProfile waterProfile);
    List<WaterProfile> findAll();
    void deleteAll();
}
