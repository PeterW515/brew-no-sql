package com.hopsoft.brew.brewing.service.impl;

import com.hopsoft.brew.brewing.domain.YeastLine;
import com.hopsoft.brew.brewing.repository.YeastLineRepository;
import com.hopsoft.brew.brewing.service.api.YeastLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YeastLineServiceImpl implements YeastLineService {

    @Autowired
    YeastLineRepository yeastLineRepository;

    @Override
    public YeastLine saveYeastLine(YeastLine yeastLine) {
        return yeastLineRepository.save(yeastLine);
    }

    @Override
    public Optional<YeastLine> findByYeastLineId(String yeastLineId) {
        return yeastLineRepository.findById(yeastLineId);
    }

    @Override
    public void deleteByYeastLineId(String yeastLineId) {
        yeastLineRepository.deleteById(yeastLineId);
    }

    @Override
    public void updateYeastLine(YeastLine yeastLine) {
        yeastLineRepository.save(yeastLine);
    }

    @Override
    public boolean yeastLineExists(YeastLine yeastLine) {
        return yeastLineRepository.exists(Example.of(yeastLine));
    }

    @Override
    public List<YeastLine> findAll() {
        return yeastLineRepository.findAll();
    }

    @Override
    public void deleteAll() {
        yeastLineRepository.deleteAll();
    }
}
