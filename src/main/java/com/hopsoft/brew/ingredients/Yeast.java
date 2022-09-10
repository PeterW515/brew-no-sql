package com.hopsoft.brew.ingredients;

import com.hopsoft.brew.ingredients.enums.Level;
import com.hopsoft.brew.ingredients.enums.YeastForm;
import com.hopsoft.brew.ingredients.enums.YeastType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Yeast {

    @Id
    private String id;

    private String yeastName;

    private Level attenuation;

    private Level floculation;

    private YeastForm yeastForm;

    private YeastType yeastType;

    public Yeast(){};

    public Yeast(String yeastName, Level attenuation, Level floculation, YeastForm yeastForm, YeastType yeastType){
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

    public Level getAttenuation() {
        return attenuation;
    }

    public void setAttenuation(Level attenuation) {
        this.attenuation = attenuation;
    }

    public Level getFloculation() {
        return floculation;
    }

    public void setFloculation(Level floculation) {
        this.floculation = floculation;
    }

    public YeastForm getYeastForm() {
        return yeastForm;
    }

    public void setYeastForm(YeastForm yeastForm) {
        this.yeastForm = yeastForm;
    }

    public YeastType getYeastType() {
        return yeastType;
    }

    public void setYeastType(YeastType yeastType) {
        this.yeastType = yeastType;
    }

    @Override
    public String toString() {
        return "Yeast{" +
                "id='" + id + '\'' +
                ", yeastName='" + yeastName + '\'' +
                ", attenuation=" + attenuation.getLevel() +
                ", floculation=" + floculation.getLevel() +
                ", yeastForm=" + yeastForm.getYeastForm() +
                ", yeastType=" + yeastType.getYeastType() +
                '}';
    }
}
