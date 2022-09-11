package com.hopsoft.brew.brewing.service.api;

import com.hopsoft.brew.brewing.domain.FermentationSchedule;

import java.util.List;
import java.util.Optional;

public interface FermentationScheduleService {
    FermentationSchedule saveFermentationSchedule(FermentationSchedule fermentationSchedule);

    Optional<FermentationSchedule> findByFermentationScheduleId(String fermentationScheduleId);

    void deleteByFermentationScheduleId(String fermentationScheduleId);

    void updateFermentationSchedule(FermentationSchedule fermentationSchedule);

    boolean fermentationScheduleExists(FermentationSchedule fermentationSchedule);

    List<FermentationSchedule> findAll();

    void deleteAll();
}
