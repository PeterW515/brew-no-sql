package com.hopsoft.brew.ingredients.service.impl;

import com.hopsoft.brew.ingredients.domain.Yeast;
import com.hopsoft.brew.ingredients.repository.YeastRepository;
import com.hopsoft.brew.ingredients.service.api.YeastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YeastServiceImpl implements YeastService {

    @Autowired
    YeastRepository yeastRepository;

    @Override
    public Yeast saveYeast(Yeast yeast) {
        return yeastRepository.save(yeast);
    }

    @Override
    public Optional<Yeast> findByYeastId(String yeastId) {
        return yeastRepository.findById(yeastId);
    }

    @Override
    public void deleteByYeastId(String yeastId) {
        yeastRepository.deleteById(yeastId);
    }

    @Override
    public void updateYeast(Yeast yeast) {
        yeastRepository.save(yeast);
    }

    @Override
    public boolean yeastExists(Yeast yeast) {
        return yeastRepository.exists(Example.of(yeast));
    }

    @Override
    public List<Yeast> findAll() {
        return yeastRepository.findAll();
    }

    @Override
    public void deleteAll() {
        yeastRepository.deleteAll();
    }
}
