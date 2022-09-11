package com.hopsoft.brew.brewing.service.api;

import com.hopsoft.brew.brewing.domain.YeastLine;

import java.util.List;
import java.util.Optional;

public interface YeastLineService {
    YeastLine saveYeastLine(YeastLine yeastLine);

    Optional<YeastLine> findByYeastLineId(String yeastLineId);

    void deleteByYeastLineId(String yeastLineId);

    void updateYeastLine(YeastLine yeastLine);

    boolean yeastLineExists(YeastLine yeastLine);

    List<YeastLine> findAll();

    void deleteAll();
}
