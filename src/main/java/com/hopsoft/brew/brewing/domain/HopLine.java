package com.hopsoft.brew.brewing.domain;

import com.hopsoft.brew.ingredients.domain.Hop;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class HopLine {
    @Id
    private String id;

    private Integer lineNumber;

    @DBRef
    private Hop hop;

    private Double quantity;

    @DBRef
    private UnitOfMeasure unitOfMeasure;

    private Double boilTime;

    private Double internationalBitternessUnits;

    public HopLine(Integer lineNumber, Hop hop, Double quantity, UnitOfMeasure unitOfMeasure, Double boilTime, Double internationalBitternessUnits) {
        this.lineNumber = lineNumber;
        this.hop = hop;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.boilTime = boilTime;
        this.internationalBitternessUnits = internationalBitternessUnits;
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

    public Hop getHop() {
        return hop;
    }

    public void setHop(Hop hop) {
        this.hop = hop;
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

    public Double getBoilTime() {
        return boilTime;
    }

    public void setBoilTime(Double boilTime) {
        this.boilTime = boilTime;
    }

    public Double getInternationalBitternessUnits() {
        return internationalBitternessUnits;
    }

    public void setInternationalBitternessUnits(Double internationalBitternessUnits) {
        this.internationalBitternessUnits = internationalBitternessUnits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HopLine hopLine = (HopLine) o;
        return id.equals(hopLine.id) && Objects.equals(lineNumber, hopLine.lineNumber) && Objects.equals(hop, hopLine.hop) && Objects.equals(quantity, hopLine.quantity) && Objects.equals(unitOfMeasure, hopLine.unitOfMeasure) && Objects.equals(boilTime, hopLine.boilTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lineNumber, hop);
    }

    @Override
    public String toString() {
        return "HopLine{" +
                "id='" + id + '\'' +
                ", lineNumber=" + lineNumber +
                ", hop=" + hop +
                ", quantity=" + quantity +
                ", unitOfMeasure=" + unitOfMeasure +
                ", boilTime=" + boilTime +
                ", internationalBitternessUnits=" + internationalBitternessUnits +
                '}';
    }
}
