package com.hopsoft.brew.brewing.service.api;

import com.hopsoft.brew.brewing.domain.UnitOfMeasure;

import java.util.List;
import java.util.Optional;

public interface UnitOfMeasureService {
    UnitOfMeasure saveUnitOfMeasure(UnitOfMeasure unitOfMeasure);

    Optional<UnitOfMeasure> findByUnitOfMeasureId(String unitOfMeasureId);

    void deleteByUnitOfMeasureId(String unitOfMeasureId);

    void updateUnitOfMeasure(UnitOfMeasure unitOfMeasure);

    boolean unitOfMeasureExists(UnitOfMeasure unitOfMeasure);

    List<UnitOfMeasure> findAll();

    void deleteAll();
}
