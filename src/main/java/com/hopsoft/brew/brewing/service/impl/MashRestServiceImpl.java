package com.hopsoft.brew.brewing.service.impl;

import com.hopsoft.brew.brewing.domain.MashRest;
import com.hopsoft.brew.brewing.repository.MashRestRepository;
import com.hopsoft.brew.brewing.service.api.MashRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MashRestServiceImpl implements MashRestService {

    @Autowired
    MashRestRepository mashRestRepository;

    @Override
    public MashRest saveMashRest(MashRest mashRest) {
        return mashRestRepository.save(mashRest);
    }

    @Override
    public Optional<MashRest> findByMashRestId(String mashRestId) {
        return mashRestRepository.findById(mashRestId);
    }

    @Override
    public void deleteByMashRestId(String mashRestId) {
        mashRestRepository.deleteById(mashRestId);
    }

    @Override
    public void updateMashRest(MashRest mashRest) {
        mashRestRepository.save(mashRest);
    }

    @Override
    public boolean mashRestExists(MashRest mashRest) {
        return mashRestRepository.exists(Example.of(mashRest));
    }

    @Override
    public List<MashRest> findAll() {
        return mashRestRepository.findAll();
    }

    @Override
    public void deleteAll() {
        mashRestRepository.deleteAll();
    }
}
