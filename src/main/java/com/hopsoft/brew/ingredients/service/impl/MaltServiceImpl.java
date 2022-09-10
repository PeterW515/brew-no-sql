package com.hopsoft.brew.ingredients.service.impl;

import com.hopsoft.brew.ingredients.domain.Malt;
import com.hopsoft.brew.ingredients.repository.MaltRepository;
import com.hopsoft.brew.ingredients.service.api.MaltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaltServiceImpl implements MaltService {

    @Autowired
    MaltRepository maltRepository;

    @Override
    public Malt saveMalt(Malt malt) {
        return maltRepository.save(malt);
    }

    @Override
    public Optional<Malt> findByMaltId(String maltId) {
        return maltRepository.findById(maltId);
    }

    @Override
    public void deleteByMaltId(String maltId) {
        maltRepository.deleteById(maltId);
    }

    @Override
    public void updateMalt(Malt malt) {
        maltRepository.save(malt);
    }

    @Override
    public boolean maltExists(Malt malt) {
        return maltRepository.exists(Example.of(malt));
    }

    @Override
    public List<Malt> findAll() {
        return maltRepository.findAll();
    }

    @Override
    public void deleteAll() {
        maltRepository.deleteAll();
    }
}
