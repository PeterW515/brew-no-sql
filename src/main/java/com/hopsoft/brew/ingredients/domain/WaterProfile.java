package com.hopsoft.brew.ingredients.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class WaterProfile {
    @Id
    private String id;
    private String waterProfileName;
    private Double calciumPPM;
    private Double magnesiumPPM;
    private Double bicarbonatePPM;
    private Double sulfatePPM;
    private Double sodiumPPM;
    private Double chloridePPM;
    private Double pH;

    public WaterProfile(){};

    public WaterProfile(String waterProfileName, Double calciumPPM, Double magnesiumPPM, Double bicarbonatePPM, Double sulfatePPM, Double sodiumPPM, Double chloridePPM, Double pH) {
        this.waterProfileName = waterProfileName;
        this.calciumPPM = calciumPPM;
        this.magnesiumPPM = magnesiumPPM;
        this.bicarbonatePPM = bicarbonatePPM;
        this.sulfatePPM = sulfatePPM;
        this.sodiumPPM = sodiumPPM;
        this.chloridePPM = chloridePPM;
        this.pH = pH;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWaterProfileName() {
        return waterProfileName;
    }

    public void setWaterProfileName(String waterProfileName) {
        this.waterProfileName = waterProfileName;
    }

    public Double getCalciumPPM() {
        return calciumPPM;
    }

    public void setCalciumPPM(Double calciumPPM) {
        this.calciumPPM = calciumPPM;
    }

    public Double getMagnesiumPPM() {
        return magnesiumPPM;
    }

    public void setMagnesiumPPM(Double magnesiumPPM) {
        this.magnesiumPPM = magnesiumPPM;
    }

    public Double getBicarbonatePPM() {
        return bicarbonatePPM;
    }

    public void setBicarbonatePPM(Double bicarbonatePPM) {
        this.bicarbonatePPM = bicarbonatePPM;
    }

    public Double getSulfatePPM() {
        return sulfatePPM;
    }

    public void setSulfatePPM(Double sulfatePPM) {
        this.sulfatePPM = sulfatePPM;
    }

    public Double getSodiumPPM() {
        return sodiumPPM;
    }

    public void setSodiumPPM(Double sodiumPPM) {
        this.sodiumPPM = sodiumPPM;
    }

    public Double getChloridePPM() {
        return chloridePPM;
    }

    public void setChloridePPM(Double chloridePPM) {
        this.chloridePPM = chloridePPM;
    }

    public Double getpH() {
        return pH;
    }

    public void setpH(Double pH) {
        this.pH = pH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterProfile that = (WaterProfile) o;
        return id.equals(that.id) && waterProfileName.equals(that.waterProfileName) && Objects.equals(pH, that.pH);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, waterProfileName, pH);
    }

    @Override
    public String toString() {
        return "WaterProfile{" +
                "id='" + id + '\'' +
                ", waterProfileName='" + waterProfileName + '\'' +
                ", calciumPPM=" + calciumPPM +
                ", magnesiumPPM=" + magnesiumPPM +
                ", bicarbonatePPM=" + bicarbonatePPM +
                ", sulfatePPM=" + sulfatePPM +
                ", sodiumPPM=" + sodiumPPM +
                ", chloridePPM=" + chloridePPM +
                ", ph=" + pH +
                '}';
    }


}
