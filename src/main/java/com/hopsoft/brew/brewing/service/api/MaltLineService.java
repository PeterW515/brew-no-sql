package com.hopsoft.brew.brewing.service.api;

import com.hopsoft.brew.brewing.domain.MaltLine;

import java.util.List;
import java.util.Optional;

public interface MaltLineService {
    MaltLine saveMaltLine(MaltLine maltLine);

    Optional<MaltLine> findByMaltLineId(String maltLineId);

    void deleteByMaltLineId(String maltLineId);

    void updateMaltLine(MaltLine maltLine);

    boolean maltLineExists(MaltLine maltLine);

    List<MaltLine> findAll();

    void deleteAll();
}
