package com.hopsoft.brew.brewing.service.impl;

import com.hopsoft.brew.brewing.domain.UnitOfMeasure;
import com.hopsoft.brew.brewing.repository.UnitOfMeasureRepository;
import com.hopsoft.brew.brewing.service.api.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public UnitOfMeasure saveUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        return unitOfMeasureRepository.save(unitOfMeasure);
    }

    @Override
    public Optional<UnitOfMeasure> findByUnitOfMeasureId(String unitOfMeasureId) {
        return unitOfMeasureRepository.findById(unitOfMeasureId);
    }

    @Override
    public void deleteByUnitOfMeasureId(String unitOfMeasureId) {
        unitOfMeasureRepository.deleteById(unitOfMeasureId);
    }

    @Override
    public void updateUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        unitOfMeasureRepository.save(unitOfMeasure);
    }

    @Override
    public boolean unitOfMeasureExists(UnitOfMeasure unitOfMeasure) {
        return unitOfMeasureRepository.exists(Example.of(unitOfMeasure));
    }

    @Override
    public List<UnitOfMeasure> findAll() {
        return unitOfMeasureRepository.findAll();
    }

    @Override
    public void deleteAll() {
        unitOfMeasureRepository.deleteAll();
    }
}
