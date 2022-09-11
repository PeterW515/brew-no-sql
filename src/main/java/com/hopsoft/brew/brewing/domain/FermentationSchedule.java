package com.hopsoft.brew.brewing.domain;

import com.hopsoft.brew.brewing.enums.Stage;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class FermentationSchedule {
    @Id
    private String id;

    private Double numDays;

    private Double minTemp;

    private Double maxTemp;

    private Double nominalTemp;

    private Stage stage;

    public FermentationSchedule(Double numDays, Double minTemp, Double maxTemp, Double nominalTemp, Stage stage) {
        this.numDays = numDays;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.nominalTemp = nominalTemp;
        this.stage = stage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getNumDays() {
        return numDays;
    }

    public void setNumDays(Double numDays) {
        this.numDays = numDays;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getNominalTemp() {
        return nominalTemp;
    }

    public void setNominalTemp(Double nominalTemp) {
        this.nominalTemp = nominalTemp;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FermentationSchedule that = (FermentationSchedule) o;
        return id.equals(that.id) && Objects.equals(numDays, that.numDays) && Objects.equals(nominalTemp, that.nominalTemp) && stage == that.stage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numDays, nominalTemp, stage);
    }

    @Override
    public String toString() {
        return "FermentationSchedule{" +
                "id='" + id + '\'' +
                ", numDays=" + numDays +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", nominalTemp=" + nominalTemp +
                ", stage=" + stage +
                '}';
    }
}
