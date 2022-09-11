package com.hopsoft.brew.brewing.service.api;

import com.hopsoft.brew.brewing.domain.HopLine;

import java.util.List;
import java.util.Optional;

public interface HopLineService {
    HopLine saveHopLine(HopLine hopLine);

    Optional<HopLine> findByHopLineId(String hopLineId);

    void deleteByHopLineId(String hopLineId);

    void updateHopLine(HopLine hopLine);

    boolean hopLineExists(HopLine hopLine);

    List<HopLine> findAll();

    void deleteAll();
}
