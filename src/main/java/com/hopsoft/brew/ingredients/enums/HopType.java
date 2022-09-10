package com.hopsoft.brew.ingredients.enums;

public enum HopType {
    BITTERING ("Bittering"),
    AROMA ("Aroma"),
    BOTH ("Both");

    private final String hopType;

    HopType(String hopType){
        this.hopType = hopType;
    }

    public String getHopType(){
        return hopType;
    }
}
