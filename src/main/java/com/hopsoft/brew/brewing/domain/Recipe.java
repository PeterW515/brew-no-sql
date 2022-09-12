package com.hopsoft.brew.brewing.domain;

import com.hopsoft.brew.brewing.enums.Style;
import com.hopsoft.brew.ingredients.domain.WaterProfile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Recipe {

    @Id
    private String id;

    private String recipeName;

    private Style recipeStyle;

    private Double originalGravityLowerBound;

    private Double originalGravityUpperBound;

    private Double nominalOriginalGravity;

    private Double degreesPlatoLowerBound;

    private Double degreesPlatoUpperBound;

    private Double nominalDegreesPlato;

    private Double finalGravityLowerBound;

    private Double finalGravityUpperBound;

    private Double nominalFinalGravity;

    private Double lowerBoundIBUs;

    private Double upperBoundIBUs;

    private Double nominalIBUs;

    private Double nominalColor;

    private Double colorUpperBound;

    private Double colorLowerBound;

    @DBRef
    private List<MaltLine> maltLines;

    @DBRef
    private List<HopLine> hopLines;

    @DBRef
    private List<YeastLine> yeastLines;

    @DBRef
    private WaterProfile waterProfile;

    @DBRef
    private MashSchedule mashSchedule;

    public Recipe(String recipeName, Style recipeStyle, Double originalGravityLowerBound, Double originalGravityUpperBound, Double nominalOriginalGravity, Double degreesPlatoLowerBound, Double degreesPlatoUpperBound, Double nominalDegreesPlato, Double finalGravityLowerBound, Double finalGravityUpperBound, Double nominalFinalGravity, Double lowerBoundIBUs, Double upperBoundIBUs, Double nominalIBUs, Double nominalColor, Double colorUpperBound, Double colorLowerBound, List<MaltLine> maltLines, List<HopLine> hopLines, List<YeastLine> yeastLines, WaterProfile waterProfile, MashSchedule mashSchedule) {
        this.recipeName = recipeName;
        this.recipeStyle = recipeStyle;
        this.originalGravityLowerBound = originalGravityLowerBound;
        this.originalGravityUpperBound = originalGravityUpperBound;
        this.nominalOriginalGravity = nominalOriginalGravity;
        this.degreesPlatoLowerBound = degreesPlatoLowerBound;
        this.degreesPlatoUpperBound = degreesPlatoUpperBound;
        this.nominalDegreesPlato = nominalDegreesPlato;
        this.finalGravityLowerBound = finalGravityLowerBound;
        this.finalGravityUpperBound = finalGravityUpperBound;
        this.nominalFinalGravity = nominalFinalGravity;
        this.lowerBoundIBUs = lowerBoundIBUs;
        this.upperBoundIBUs = upperBoundIBUs;
        this.nominalIBUs = nominalIBUs;
        this.nominalColor = nominalColor;
        this.colorUpperBound = colorUpperBound;
        this.colorLowerBound = colorLowerBound;
        this.maltLines = maltLines;
        this.hopLines = hopLines;
        this.yeastLines = yeastLines;
        this.waterProfile = waterProfile;
        this.mashSchedule = mashSchedule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Style getRecipeStyle() {
        return recipeStyle;
    }

    public void setRecipeStyle(Style recipeStyle) {
        this.recipeStyle = recipeStyle;
    }

    public Double getOriginalGravityLowerBound() {
        return originalGravityLowerBound;
    }

    public void setOriginalGravityLowerBound(Double originalGravityLowerBound) {
        this.originalGravityLowerBound = originalGravityLowerBound;
    }

    public Double getOriginalGravityUpperBound() {
        return originalGravityUpperBound;
    }

    public void setOriginalGravityUpperBound(Double originalGravityUpperBound) {
        this.originalGravityUpperBound = originalGravityUpperBound;
    }

    public Double getNominalOriginalGravity() {
        return nominalOriginalGravity;
    }

    public void setNominalOriginalGravity(Double nominalOriginalGravity) {
        this.nominalOriginalGravity = nominalOriginalGravity;
    }

    public Double getDegreesPlatoLowerBound() {
        return degreesPlatoLowerBound;
    }

    public void setDegreesPlatoLowerBound(Double degreesPlatoLowerBound) {
        this.degreesPlatoLowerBound = degreesPlatoLowerBound;
    }

    public Double getDegreesPlatoUpperBound() {
        return degreesPlatoUpperBound;
    }

    public void setDegreesPlatoUpperBound(Double degreesPlatoUpperBound) {
        this.degreesPlatoUpperBound = degreesPlatoUpperBound;
    }

    public Double getNominalDegreesPlato() {
        return nominalDegreesPlato;
    }

    public void setNominalDegreesPlato(Double nominalDegreesPlato) {
        this.nominalDegreesPlato = nominalDegreesPlato;
    }

    public Double getFinalGravityLowerBound() {
        return finalGravityLowerBound;
    }

    public void setFinalGravityLowerBound(Double finalGravityLowerBound) {
        this.finalGravityLowerBound = finalGravityLowerBound;
    }

    public Double getFinalGravityUpperBound() {
        return finalGravityUpperBound;
    }

    public void setFinalGravityUpperBound(Double finalGravityUpperBound) {
        this.finalGravityUpperBound = finalGravityUpperBound;
    }

    public Double getNominalFinalGravity() {
        return nominalFinalGravity;
    }

    public void setNominalFinalGravity(Double nominalFinalGravity) {
        this.nominalFinalGravity = nominalFinalGravity;
    }

    public Double getLowerBoundIBUs() {
        return lowerBoundIBUs;
    }

    public void setLowerBoundIBUs(Double lowerBoundIBUs) {
        this.lowerBoundIBUs = lowerBoundIBUs;
    }

    public Double getUpperBoundIBUs() {
        return upperBoundIBUs;
    }

    public void setUpperBoundIBUs(Double upperBoundIBUs) {
        this.upperBoundIBUs = upperBoundIBUs;
    }

    public Double getNominalIBUs() {
        return nominalIBUs;
    }

    public void setNominalIBUs(Double nominalIBUs) {
        this.nominalIBUs = nominalIBUs;
    }

    public Double getNominalColor() {
        return nominalColor;
    }

    public void setNominalColor(Double nominalColor) {
        this.nominalColor = nominalColor;
    }

    public Double getColorUpperBound() {
        return colorUpperBound;
    }

    public void setColorUpperBound(Double colorUpperBound) {
        this.colorUpperBound = colorUpperBound;
    }

    public Double getColorLowerBound() {
        return colorLowerBound;
    }

    public void setColorLowerBound(Double colorLowerBound) {
        this.colorLowerBound = colorLowerBound;
    }

    public List<MaltLine> getMaltLines() {
        return maltLines;
    }

    public void setMaltLines(List<MaltLine> maltLines) {
        this.maltLines = maltLines;
    }

    public List<HopLine> getHopLines() {
        return hopLines;
    }

    public void setHopLines(List<HopLine> hopLines) {
        this.hopLines = hopLines;
    }

    public List<YeastLine> getYeastLines() {
        return yeastLines;
    }

    public void setYeastLines(List<YeastLine> yeastLines) {
        this.yeastLines = yeastLines;
    }

    public WaterProfile getWaterProfile() {
        return waterProfile;
    }

    public void setWaterProfile(WaterProfile waterProfile) {
        this.waterProfile = waterProfile;
    }

    public MashSchedule getMashSchedule() {
        return mashSchedule;
    }

    public void setMashSchedule(MashSchedule mashSchedule) {
        this.mashSchedule = mashSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id.equals(recipe.id) && recipeName.equals(recipe.recipeName) && recipeStyle == recipe.recipeStyle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeName, recipeStyle);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeName='" + recipeName + '\'' +
                ", recipeStyle=" + recipeStyle +
                ", originalGravityLowerBound=" + originalGravityLowerBound +
                ", originalGravityUpperBound=" + originalGravityUpperBound +
                ", nominalOriginalGravity=" + nominalOriginalGravity +
                ", degreesPlatoLowerBound=" + degreesPlatoLowerBound +
                ", degreesPlatoUpperBound=" + degreesPlatoUpperBound +
                ", nominalDegreesPlato=" + nominalDegreesPlato +
                ", finalGravityLowerBound=" + finalGravityLowerBound +
                ", finalGravityUpperBound=" + finalGravityUpperBound +
                ", nominalFinalGravity=" + nominalFinalGravity +
                ", lowerBoundIBUs=" + lowerBoundIBUs +
                ", upperBoundIBUs=" + upperBoundIBUs +
                ", nominalIBUs=" + nominalIBUs +
                ", nominalColor=" + nominalColor +
                ", colorUpperBound=" + colorUpperBound +
                ", colorLowerBound=" + colorLowerBound +
                ", maltLines=" + maltLines +
                ", hopLines=" + hopLines +
                ", yeastLines=" + yeastLines +
                ", waterProfile=" + waterProfile +
                ", mashSchedule=" + mashSchedule +
                '}';
    }
}
