package com.hopsoft.brew.ingredients.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Yeast {

    @Id
    private String id;

    private String yeastName;

    private String attenuation;

    private String floculation;

    private String yeastForm;

    private String yeastType;

    public Yeast(){};

    public Yeast(String yeastName, String attenuation, String floculation, String yeastForm, String yeastType){
        this.yeastName =yeastName;
        this.attenuation=attenuation;
        this.floculation=floculation;
        this.yeastForm=yeastForm;
        this.yeastType=yeastType;
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

    @Override
    public String toString() {
        return "Yeast{" +
                "id='" + id + '\'' +
                ", yeastName='" + yeastName + '\'' +
                ", attenuation=" + attenuation +
                ", floculation=" + floculation +
                ", yeastForm=" + yeastForm +
                ", yeastType=" + yeastType +
                '}';
    }
}
