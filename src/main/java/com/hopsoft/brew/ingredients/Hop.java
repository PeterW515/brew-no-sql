package com.hopsoft.brew.ingredients;


import com.hopsoft.brew.ingredients.enums.HopType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hop {

    @Id
    private String id;

    private String hopName;

    private double alphaAcidPercent;

    private HopType hopType;

    private boolean noble;

    public Hop(){};

    public Hop(String hopName, double alphaAcidPercent, HopType hopType, boolean noble) {
        this.hopName = hopName;
        this.alphaAcidPercent = alphaAcidPercent;
        this.hopType = hopType;
        this.noble = noble;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHopName() {
        return hopName;
    }

    public void setHopName(String hopName) {
        this.hopName = hopName;
    }

    public double getAlphaAcidPercent() {
        return alphaAcidPercent;
    }

    public void setAlphaAcidPercent(double alphaAcidPercent) {
        this.alphaAcidPercent = alphaAcidPercent;
    }

    public String getHopType() {
        return hopType.getHopType();
    }

    public void setHopType(HopType hopType) {
        this.hopType = hopType;
    }

    public boolean isNoble() {
        return noble;
    }

    public void setNoble(boolean noble) {
        this.noble = noble;
    }

    @Override
    public String toString() {
        return "Hop{" +
                "id='" + id + '\'' +
                ", hopName='" + hopName + '\'' +
                ", alphaAcidPercent=" + alphaAcidPercent +
                ", hopType='" + hopType.getHopType() + '\'' +
                ", noble=" + noble +
                '}';
    }
}