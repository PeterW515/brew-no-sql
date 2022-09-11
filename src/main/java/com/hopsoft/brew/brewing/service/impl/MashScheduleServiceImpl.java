package com.hopsoft.brew.brewing.service.impl;

import com.hopsoft.brew.brewing.domain.MashSchedule;
import com.hopsoft.brew.brewing.repository.MashScheduleRepository;
import com.hopsoft.brew.brewing.service.api.MashScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MashScheduleServiceImpl implements MashScheduleService {

    @Autowired
    MashScheduleRepository mashScheduleRepository;

    @Override
    public MashSchedule saveMashSchedule(MashSchedule mashSchedule) {
        return mashScheduleRepository.save(mashSchedule);
    }

    @Override
    public Optional<MashSchedule> findByMashScheduleId(String mashScheduleId) {
        return mashScheduleRepository.findById(mashScheduleId);
    }

    @Override
    public void deleteByMashScheduleId(String mashScheduleId) {
        mashScheduleRepository.deleteById(mashScheduleId);
    }

    @Override
    public void updateMashSchedule(MashSchedule mashSchedule) {
        mashScheduleRepository.save(mashSchedule);
    }

    @Override
    public boolean mashScheduleExists(MashSchedule mashSchedule) {
        return mashScheduleRepository.exists(Example.of(mashSchedule));
    }

    @Override
    public List<MashSchedule> findAll() {
        return mashScheduleRepository.findAll();
    }

    @Override
    public void deleteAll() {
        mashScheduleRepository.deleteAll();
    }
}
