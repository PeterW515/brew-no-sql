package com.hopsoft.brew.brewing.service.api;

import com.hopsoft.brew.brewing.domain.MashSchedule;

import java.util.List;
import java.util.Optional;

public interface MashScheduleService {
    MashSchedule saveMashSchedule(MashSchedule mashSchedule);

    Optional<MashSchedule> findByMashScheduleId(String mashScheduleId);

    void deleteByMashScheduleId(String mashScheduleId);

    void updateMashSchedule(MashSchedule mashSchedule);

    boolean mashScheduleExists(MashSchedule mashSchedule);

    List<MashSchedule> findAll();

    void deleteAll();
}
