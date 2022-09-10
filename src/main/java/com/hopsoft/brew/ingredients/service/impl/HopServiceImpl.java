package com.hopsoft.brew.ingredients.service.impl;

import com.hopsoft.brew.ingredients.domain.Hop;
import com.hopsoft.brew.ingredients.repository.HopRepository;
import com.hopsoft.brew.ingredients.service.api.HopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HopServiceImpl implements HopService {

    @Autowired
    HopRepository hopRepository;

    @Override
    public Hop saveHop(Hop hop) {
        return hopRepository.save(hop);
    }

    @Override
    public Optional<Hop> findByHopId(String hopId) {
        return hopRepository.findById(hopId);
    }

    @Override
    public void deleteByHopId(String hopId) {
        hopRepository.deleteById(hopId);
    }

    @Override
    public void updateHop(Hop hop) {
        hopRepository.save(hop);
    }

    @Override
    public boolean hopExists(Hop hop) {
        return hopRepository.exists(Example.of(hop));
    }

    @Override
    public List<Hop> findAll() {
        return hopRepository.findAll();
    }

    @Override
    public void deleteAll() {
        hopRepository.deleteAll();
    }
}
