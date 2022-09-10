package com.hopsoft.brew.ingredients.enums;

public enum Level {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private final String level;

    Level(String level){ this.level = level;}

    public String getLevel(){return level;}
}
