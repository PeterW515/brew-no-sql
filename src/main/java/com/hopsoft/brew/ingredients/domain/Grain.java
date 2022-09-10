package com.hopsoft.brew.ingredients.domain;


public abstract class Grain {

    private String grainType;

    public String getGrainType() {
        return grainType;
    }

    public void setGrainType(String grainType){
        this.grainType=grainType;
    }
}
