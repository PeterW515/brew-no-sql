package com.hopsoft.brew.ingredients.enums;

public enum YeastType {
    ALE("Ale"),
    LAGER("Lager");

    private final String yeastType;

    YeastType(String yeastType){
        this.yeastType = yeastType;
    }

    public String getYeastType(){
        return yeastType;
    }
}
