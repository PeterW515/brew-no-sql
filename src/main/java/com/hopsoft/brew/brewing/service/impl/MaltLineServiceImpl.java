package com.hopsoft.brew.brewing.service.impl;

import com.hopsoft.brew.brewing.domain.MaltLine;
import com.hopsoft.brew.brewing.repository.MaltLineRepository;
import com.hopsoft.brew.brewing.service.api.MaltLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaltLineServiceImpl implements MaltLineService {

    @Autowired
    MaltLineRepository maltLineRepository;

    @Override
    public MaltLine saveMaltLine(MaltLine maltLine) {
        return maltLineRepository.save(maltLine);
    }

    @Override
    public Optional<MaltLine> findByMaltLineId(String maltLineId) {
        return maltLineRepository.findById(maltLineId);
    }

    @Override
    public void deleteByMaltLineId(String maltLineId) {
        maltLineRepository.deleteById(maltLineId);
    }

    @Override
    public void updateMaltLine(MaltLine maltLine) {
        maltLineRepository.save(maltLine);
    }

    @Override
    public boolean maltLineExists(MaltLine maltLine) {
        return maltLineRepository.exists(Example.of(maltLine));
    }

    @Override
    public List<MaltLine> findAll() {
        return maltLineRepository.findAll();
    }

    @Override
    public void deleteAll() {
        maltLineRepository.deleteAll();
    }
}
