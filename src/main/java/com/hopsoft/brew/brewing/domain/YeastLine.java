package com.hopsoft.brew.brewing.domain;

import com.hopsoft.brew.ingredients.domain.Yeast;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import sun.tools.jconsole.Plotter;

import java.util.Objects;

@Document
public class YeastLine {

    @Id
    private String id;

    private Integer lineNumber;

    @DBRef
    private Yeast yeast;

    private Double quantity;

    @DBRef
    private UnitOfMeasure unitOfMeasure;

    @DBRef
    private FermentationSchedule fermentationSchedule;

    public YeastLine(Integer lineNumber, Yeast yeast, Double quantity, UnitOfMeasure unitOfMeasure, FermentationSchedule fermentationSchedule) {
        this.lineNumber = lineNumber;
        this.yeast = yeast;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.fermentationSchedule = fermentationSchedule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Yeast getYeast() {
        return yeast;
    }

    public void setYeast(Yeast yeast) {
        this.yeast = yeast;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public FermentationSchedule getFermentationSchedule() {
        return fermentationSchedule;
    }

    public void setFermentationSchedule(FermentationSchedule fermentationSchedule) {
        this.fermentationSchedule = fermentationSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YeastLine yeastLine = (YeastLine) o;
        return id.equals(yeastLine.id) && yeast.equals(yeastLine.yeast) && Objects.equals(quantity, yeastLine.quantity) && Objects.equals(unitOfMeasure, yeastLine.unitOfMeasure) && Objects.equals(fermentationSchedule, yeastLine.fermentationSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yeast, quantity);
    }

    @Override
    public String toString() {
        return "YeastLine{" +
                "id='" + id + '\'' +
                ", lineNumber=" + lineNumber +
                ", yeast=" + yeast +
                ", quantity=" + quantity +
                ", unitOfMeasure=" + unitOfMeasure +
                ", fermentationSchedule=" + fermentationSchedule +
                '}';
    }
}
