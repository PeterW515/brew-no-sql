package com.hopsoft.brew.ingredients.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Malt {
    @Id
    private String id;
    private String maltName;
    private String maltType;
    private Double percentExtractFineGrindDryBasis;
    private Double mealy;
    private Double half;
    private Double glassy;
    private Double sizeSevenSixtyFourths;
    private Double sizeSixSixtyFourths;
    private Double sizeFiveSixtyFourths;
    private Double sizeThru;
    private Double percentMoisture;
    private Double fineCoarseDifference;
    private Double percentExtractCoarseGrindDryBasis;
    private Double protein;
    private Double solubleToTotalProteinRatio;
    private Double diastaticPower;
    private Double color;
    private String grainType;

    public Malt(){};

    public Malt(String maltName, String maltType, Double percentExtractFineGrindDryBasis, Double mealy, Double half, Double glassy, Double sizeSevenSixtyFourths, Double sizeSixSixtyFourths, Double sizeFiveSixtyFourths, Double sizeThru, Double percentMoisture, Double fineCoarseDifference, Double percentExtractCoarseGrindDryBasis, Double protein, Double solubleToTotalProteinRatio, Double diastaticPower, Double color, String grainType) {
        this.maltName = maltName;
        this.maltType = maltType;
        this.percentExtractFineGrindDryBasis = percentExtractFineGrindDryBasis;
        this.mealy = mealy;
        this.half = half;
        this.glassy = glassy;
        this.sizeSevenSixtyFourths = sizeSevenSixtyFourths;
        this.sizeSixSixtyFourths = sizeSixSixtyFourths;
        this.sizeFiveSixtyFourths = sizeFiveSixtyFourths;
        this.sizeThru = sizeThru;
        this.percentMoisture = percentMoisture;
        this.fineCoarseDifference = fineCoarseDifference;
        this.percentExtractCoarseGrindDryBasis = percentExtractCoarseGrindDryBasis;
        this.protein = protein;
        this.solubleToTotalProteinRatio = solubleToTotalProteinRatio;
        this.diastaticPower = diastaticPower;
        this.color = color;
        this.grainType = grainType;
    }

    public Malt(MaltBuilder maltBuilder) {
        this.maltName = maltBuilder.maltName;
        this.maltType = maltBuilder.maltType;
        this.percentExtractFineGrindDryBasis = maltBuilder.percentExtractFineGrindDryBasis;
        this.mealy = maltBuilder.mealy;
        this.half = maltBuilder.half;
        this.glassy = maltBuilder.glassy;
        this.sizeSevenSixtyFourths = maltBuilder.sizeSevenSixtyFourths;
        this.sizeSixSixtyFourths = maltBuilder.sizeSixSixtyFourths;
        this.sizeFiveSixtyFourths = maltBuilder.sizeFiveSixtyFourths;
        this.sizeThru = maltBuilder.sizeThru;
        this.percentMoisture = maltBuilder.percentMoisture;
        this.fineCoarseDifference = maltBuilder.fineCoarseDifference;
        this.percentExtractCoarseGrindDryBasis = maltBuilder.percentExtractCoarseGrindDryBasis;
        this.protein = maltBuilder.protein;
        this.solubleToTotalProteinRatio = maltBuilder.solubleToTotalProteinRatio;
        this.diastaticPower = maltBuilder.diastaticPower;
        this.color = maltBuilder.color;
        this.grainType=maltBuilder.grainType;
    }

    public String getId() {
        return id;
    }

    public String getMaltName() {
        return maltName;
    }

    public String getMaltType() {
        return maltType;
    }

    public Double getPercentExtractFineGrindDryBasis() {
        return percentExtractFineGrindDryBasis;
    }

    public Double getMealy() {
        return mealy;
    }

    public Double getHalf() {
        return half;
    }

    public Double getGlassy() {
        return glassy;
    }

    public Double getSizeSevenSixtyFourths() {
        return sizeSevenSixtyFourths;
    }

    public Double getSizeSixSixtyFourths() {
        return sizeSixSixtyFourths;
    }

    public Double getSizeFiveSixtyFourths() {
        return sizeFiveSixtyFourths;
    }

    public Double getSizeThru() {
        return sizeThru;
    }

    public Double getPercentMoisture() {
        return percentMoisture;
    }

    public Double getFineCoarseDifference() {
        return fineCoarseDifference;
    }

    public Double getPercentExtractCoarseGrindDryBasis() {
        return percentExtractCoarseGrindDryBasis;
    }

    public Double getProtein() {
        return protein;
    }

    public Double getSolubleToTotalProteinRatio() {
        return solubleToTotalProteinRatio;
    }

    public Double getDiastaticPower() {
        return diastaticPower;
    }

    public Double getColor() {
        return color;
    }

    public String getGrainType(){
        return grainType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMaltName(String maltName) {
        this.maltName = maltName;
    }

    public void setMaltType(String maltType) {
        this.maltType = maltType;
    }

    public void setPercentExtractFineGrindDryBasis(Double percentExtractFineGrindDryBasis) {
        this.percentExtractFineGrindDryBasis = percentExtractFineGrindDryBasis;
    }

    public void setMealy(Double mealy) {
        this.mealy = mealy;
    }

    public void setHalf(Double half) {
        this.half = half;
    }

    public void setGlassy(Double glassy) {
        this.glassy = glassy;
    }

    public void setSizeSevenSixtyFourths(Double sizeSevenSixtyFourths) {
        this.sizeSevenSixtyFourths = sizeSevenSixtyFourths;
    }

    public void setSizeSixSixtyFourths(Double sizeSixSixtyFourths) {
        this.sizeSixSixtyFourths = sizeSixSixtyFourths;
    }

    public void setSizeFiveSixtyFourths(Double sizeFiveSixtyFourths) {
        this.sizeFiveSixtyFourths = sizeFiveSixtyFourths;
    }

    public void setSizeThru(Double sizeThru) {
        this.sizeThru = sizeThru;
    }

    public void setPercentMoisture(Double percentMoisture) {
        this.percentMoisture = percentMoisture;
    }

    public void setFineCoarseDifference(Double fineCoarseDifference) {
        this.fineCoarseDifference = fineCoarseDifference;
    }

    public void setPercentExtractCoarseGrindDryBasis(Double percentExtractCoarseGrindDryBasis) {
        this.percentExtractCoarseGrindDryBasis = percentExtractCoarseGrindDryBasis;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public void setSolubleToTotalProteinRatio(Double solubleToTotalProteinRatio) {
        this.solubleToTotalProteinRatio = solubleToTotalProteinRatio;
    }

    public void setDiastaticPower(Double diastaticPower) {
        this.diastaticPower = diastaticPower;
    }

    public void setColor(Double color) {
        this.color = color;
    }

    public void setGrainType(String grainType) {
        this.grainType = grainType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Malt malt = (Malt) o;
        return id.equals(malt.id) && maltName.equals(malt.maltName) && Objects.equals(maltType, malt.maltType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maltName, maltType);
    }

    @Override
    public String toString() {
        return "Malt{" +
                "id='" + id + '\'' +
                ", maltName='" + maltName + '\'' +
                ", maltType='" + maltType + '\'' +
                ", diastaticPower=" + diastaticPower +
                ", color=" + color +
                '}';
    }

    public static class MaltBuilder {
        private String maltName;
        private String maltType;
        private Double percentExtractFineGrindDryBasis;
        private Double mealy;
        private Double half;
        private Double glassy;
        private Double sizeSevenSixtyFourths;
        private Double sizeSixSixtyFourths;
        private Double sizeFiveSixtyFourths;
        private Double sizeThru;
        private Double percentMoisture;
        private Double fineCoarseDifference;
        private Double percentExtractCoarseGrindDryBasis;
        private Double protein;
        private Double solubleToTotalProteinRatio;
        private Double diastaticPower;
        private Double color;
        private String grainType;

        public MaltBuilder(String maltName) {
            this.maltName = maltName;
        }

        public MaltBuilder setMaltType(String maltType) {
            this.maltType = maltType;
            return this;
        }

        public MaltBuilder setPercentExtractFineGrindDryBasis(Double percentExtractFineGrindDryBasis) {
            this.percentExtractFineGrindDryBasis = percentExtractFineGrindDryBasis;
            return this;
        }

        public MaltBuilder setMealy(Double mealy) {
            this.mealy = mealy;
            return this;
        }

        public MaltBuilder setHalf(Double half) {
            this.half = half;
            return this;
        }

        public MaltBuilder setGlassy(Double glassy) {
            this.glassy = glassy;
            return this;
        }

        public MaltBuilder setSizeSevenSixtyFourths(Double sizeSevenSixtyFourths) {
            this.sizeSevenSixtyFourths = sizeSevenSixtyFourths;
            return this;
        }

        public MaltBuilder setSizeSixSixtyFourths(Double sizeSixSixtyFourths) {
            this.sizeSixSixtyFourths = sizeSixSixtyFourths;
            return this;
        }

        public MaltBuilder setSizeFiveSixtyFourths(Double sizeFiveSixtyFourths) {
            this.sizeFiveSixtyFourths = sizeFiveSixtyFourths;
            return this;
        }

        public MaltBuilder setSizeThru(Double sizeThru) {
            this.sizeThru = sizeThru;
            return this;
        }

        public MaltBuilder setPercentMoisture(Double percentMoisture) {
            this.percentMoisture = percentMoisture;
            return this;
        }

        public MaltBuilder setFineCoarseDifference(Double fineCoarseDifference) {
            this.fineCoarseDifference = fineCoarseDifference;
            return this;
        }

        public MaltBuilder setPercentExtractCoarseGrindDryBasis(Double percentExtractCoarseGrindDryBasis) {
            this.percentExtractCoarseGrindDryBasis = percentExtractCoarseGrindDryBasis;
            return this;
        }

        public MaltBuilder setProtein(Double protein) {
            this.protein = protein;
            return this;
        }

        public MaltBuilder setSolubleToTotalProteinRatio(Double solubleToTotalProteinRatio) {
            this.solubleToTotalProteinRatio = solubleToTotalProteinRatio;
            return this;
        }

        public MaltBuilder setDiastaticPower(Double diastaticPower) {
            this.diastaticPower = diastaticPower;
            return this;
        }

        public MaltBuilder setColor(Double color) {
            this.color = color;
            return this;
        }

        public MaltBuilder setGrainType(String grainType){
            this.grainType=grainType;
            return this;
        }

        public Malt build(){
            Malt malt = new Malt(this);
            validateMaltObject(malt);
            return malt;
        }

        private void validateMaltObject(Malt malt){
            //placeholder method
        }
    }
}
