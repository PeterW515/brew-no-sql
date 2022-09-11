package com.hopsoft.brew.brewing.domain;


import com.hopsoft.brew.ingredients.domain.Malt;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class MaltLine {

    @Id
    private String id;

    private Integer lineNumber;

    @DBRef
    private Malt malt;

    private Double quantity;

    @DBRef
    private UnitOfMeasure unitOfMeasure;

    public MaltLine(){};

    public MaltLine(Integer lineNumber, Malt malt, Double quantity, UnitOfMeasure unitOfMeasure) {
        this.lineNumber = lineNumber;
        this.malt = malt;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
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

    public Malt getMalt() {
        return malt;
    }

    public void setMalt(Malt malt) {
        this.malt = malt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaltLine maltLine = (MaltLine) o;
        return id.equals(maltLine.id) && lineNumber.equals(maltLine.lineNumber) && malt.equals(maltLine.malt) && Objects.equals(quantity, maltLine.quantity) && Objects.equals(unitOfMeasure, maltLine.unitOfMeasure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lineNumber, malt, quantity, unitOfMeasure);
    }

    @Override
    public String toString() {
        return "MaltLine{" +
                "id='" + id + '\'' +
                ", lineNumber=" + lineNumber +
                ", malt=" + malt +
                ", quantity=" + quantity +
                ", unitOfMeasure=" + unitOfMeasure +
                '}';
    }
}
