package com.hopsoft.brew.ingredients.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Yeast {

    @Id
    private String id;

    private String yeastName;

    private String attenuation;

    private String floculation;

    private String yeastForm;

    private String yeastType;

    private Double alcoholTolerance;

    private Double attenuationLowerBound;

    private Double attenuationUpperBound;

    private Double nominalAttenuationPercent;

    private Double temperatureLowerBound;

    private Double temperatureUpperBound;

    private Double nominalTemperature;

    public Yeast(){};

    public Yeast(String yeastName, String attenuation, String floculation, String yeastForm, String yeastType, Double alcoholTolerance, Double attenuationLowerBound, Double attenuationUpperBound, Double nominalAttenuationPercent, Double temperatureLowerBound, Double temperatureUpperBound, Double nominalTemperature) {
        this.yeastName = yeastName;
        this.attenuation = attenuation;
        this.floculation = floculation;
        this.yeastForm = yeastForm;
        this.yeastType = yeastType;
        this.alcoholTolerance = alcoholTolerance;
        this.attenuationLowerBound = attenuationLowerBound;
        this.attenuationUpperBound = attenuationUpperBound;
        this.nominalAttenuationPercent = nominalAttenuationPercent;
        this.temperatureLowerBound = temperatureLowerBound;
        this.temperatureUpperBound = temperatureUpperBound;
        this.nominalTemperature = nominalTemperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYeastName() {
        return yeastName;
    }

    public void setYeastName(String yeastName) {
        this.yeastName = yeastName;
    }

    public String getAttenuation() {
        return attenuation;
    }

    public void setAttenuation(String attenuation) {
        this.attenuation = attenuation;
    }

    public String getFloculation() {
        return floculation;
    }

    public void setFloculation(String floculation) {
        this.floculation = floculation;
    }

    public String getYeastForm() {
        return yeastForm;
    }

    public void setYeastForm(String yeastForm) {
        this.yeastForm = yeastForm;
    }

    public String getYeastType() {
        return yeastType;
    }

    public void setYeastType(String yeastType) {
        this.yeastType = yeastType;
    }

    public Double getAlcoholTolerance() {
        return alcoholTolerance;
    }

    public void setAlcoholTolerance(Double alcoholTolerance) {
        this.alcoholTolerance = alcoholTolerance;
    }

    public Double getAttenuationLowerBound() {
        return attenuationLowerBound;
    }

    public void setAttenuationLowerBound(Double attenuationLowerBound) {
        this.attenuationLowerBound = attenuationLowerBound;
    }

    public Double getAttenuationUpperBound() {
        return attenuationUpperBound;
    }

    public void setAttenuationUpperBound(Double attenuationUpperBound) {
        this.attenuationUpperBound = attenuationUpperBound;
    }

    public Double getNominalAttenuationPercent() {
        return nominalAttenuationPercent;
    }

    public void setNominalAttenuationPercent(Double nominalAttenuationPercent) {
        this.nominalAttenuationPercent = nominalAttenuationPercent;
    }

    public Double getTemperatureLowerBound() {
        return temperatureLowerBound;
    }

    public void setTemperatureLowerBound(Double temperatureLowerBound) {
        this.temperatureLowerBound = temperatureLowerBound;
    }

    public Double getTemperatureUpperBound() {
        return temperatureUpperBound;
    }

    public void setTemperatureUpperBound(Double temperatureUpperBound) {
        this.temperatureUpperBound = temperatureUpperBound;
    }

    public Double getNominalTemperature() {
        return nominalTemperature;
    }

    public void setNominalTemperature(Double nominalTemperature) {
        this.nominalTemperature = nominalTemperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yeast yeast = (Yeast) o;
        return yeastName.equals(yeast.yeastName) && Objects.equals(yeastForm, yeast.yeastForm) && Objects.equals(yeastType, yeast.yeastType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yeastName, yeastForm, yeastType);
    }

    @Override
    public String toString() {
        return "Yeast{" +
                "id='" + id + '\'' +
                ", yeastName='" + yeastName + '\'' +
                ", attenuation='" + attenuation + '\'' +
                ", floculation='" + floculation + '\'' +
                ", yeastForm='" + yeastForm + '\'' +
                ", yeastType='" + yeastType + '\'' +
                ", alcoholTolerance=" + alcoholTolerance +
                ", attenuationLowerBound=" + attenuationLowerBound +
                ", attenuationUpperBound=" + attenuationUpperBound +
                ", nominalAttenuationPercent=" + nominalAttenuationPercent +
                ", temperatureLowerBound=" + temperatureLowerBound +
                ", temperatureUpperBound=" + temperatureUpperBound +
                ", nominalTemperature=" + nominalTemperature +
                '}';
    }
}
