package com.hopsoft.brew.brewing.service.api;

import com.hopsoft.brew.brewing.domain.MashRest;

import java.util.List;
import java.util.Optional;

public interface MashRestService {
    MashRest saveMashRest(MashRest mashRest);

    Optional<MashRest> findByMashRestId(String mashRestId);

    void deleteByMashRestId(String mashRestId);

    void updateMashRest(MashRest mashRest);

    boolean mashRestExists(MashRest mashRest);

    List<MashRest> findAll();

    void deleteAll();
}
