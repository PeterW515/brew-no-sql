package com.hopsoft.brew.ingredients.service.api;

import com.hopsoft.brew.ingredients.domain.Yeast;

import java.util.List;
import java.util.Optional;

public interface YeastService {
    Yeast saveYeast(Yeast yeast);
    Optional<Yeast> findByYeastId(String yeastId);
    void deleteByYeastId(String yeastId);
    void updateYeast(Yeast yeast);
    boolean yeastExists(Yeast yeast);
    List<Yeast> findAll();
    void deleteAll();
}
