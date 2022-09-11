package com.hopsoft.brew.brewing.service.impl;

import com.hopsoft.brew.brewing.domain.HopLine;
import com.hopsoft.brew.brewing.repository.HopLineRepository;
import com.hopsoft.brew.brewing.service.api.HopLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HopLineServiceImpl implements HopLineService {

    @Autowired
    HopLineRepository hopLineRepository;

    @Override
    public HopLine saveHopLine(HopLine hopLine) {
        return hopLineRepository.save(hopLine);
    }

    @Override
    public Optional<HopLine> findByHopLineId(String hopLineId) {
        return hopLineRepository.findById(hopLineId);
    }

    @Override
    public void deleteByHopLineId(String hopLineId) {
        hopLineRepository.deleteById(hopLineId);
    }

    @Override
    public void updateHopLine(HopLine hopLine) {
        hopLineRepository.save(hopLine);
    }

    @Override
    public boolean hopLineExists(HopLine hopLine) {
        return hopLineRepository.exists(Example.of(hopLine));
    }

    @Override
    public List<HopLine> findAll() {
        return hopLineRepository.findAll();
    }

    @Override
    public void deleteAll() {
        hopLineRepository.deleteAll();
    }
}
