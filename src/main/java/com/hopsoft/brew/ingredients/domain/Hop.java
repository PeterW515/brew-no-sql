package com.hopsoft.brew.ingredients.domain;


import com.hopsoft.brew.ingredients.enums.HopPurpose;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Objects;

@Document
public class Hop {

    @Id
    private String id;

    private String hopName;

    private double alphaAcidLowerBound;

    private double alphaAcidUpperBound;

    private double nominalAlphaAcidPercent;

    private HopPurpose hopPurpose;

    private boolean noble;

    private double hopStorageIndex;

    private Map<String, Double> flavorProfile;

    public Hop() {};

    public Hop(String hopName, double alphaAcidLowerBound, double alphaAcidUpperBound, double nominalAlphaAcidPercent, HopPurpose hopPurpose, boolean noble, double hopStorageIndex, Map<String, Double> flavorProfile) {
        this.hopName = hopName;
        this.alphaAcidLowerBound = alphaAcidLowerBound;
        this.alphaAcidUpperBound = alphaAcidUpperBound;
        this.nominalAlphaAcidPercent = nominalAlphaAcidPercent;
        this.hopPurpose = hopPurpose;
        this.noble = noble;
        this.hopStorageIndex = hopStorageIndex;
        this.flavorProfile = flavorProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHopName() {
        return hopName;
    }

    public void setHopName(String hopName) {
        this.hopName = hopName;
    }

    public double getAlphaAcidLowerBound() {
        return alphaAcidLowerBound;
    }

    public void setAlphaAcidLowerBound(double alphaAcidLowerBound) {
        this.alphaAcidLowerBound = alphaAcidLowerBound;
    }

    public double getAlphaAcidUpperBound() {
        return alphaAcidUpperBound;
    }

    public void setAlphaAcidUpperBound(double alphaAcidUpperBound) {
        this.alphaAcidUpperBound = alphaAcidUpperBound;
    }

    public double getNominalAlphaAcidPercent() {
        return nominalAlphaAcidPercent;
    }

    public void setNominalAlphaAcidPercent(double nominalAlphaAcidPercent) {
        this.nominalAlphaAcidPercent = nominalAlphaAcidPercent;
    }

    public HopPurpose getHopPurpose() {
        return hopPurpose;
    }

    public void setHopPurpose(HopPurpose hopPurpose) {
        this.hopPurpose = hopPurpose;
    }

    public boolean isNoble() {
        return noble;
    }

    public void setNoble(boolean noble) {
        this.noble = noble;
    }

    public double getHopStorageIndex() {
        return hopStorageIndex;
    }

    public void setHopStorageIndex(double hopStorageIndex) {
        this.hopStorageIndex = hopStorageIndex;
    }

    public Map<String, Double> getFlavorProfile() {
        return flavorProfile;
    }

    public void setFlavorProfile(Map<String, Double> flavorProfile) {
        this.flavorProfile = flavorProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hop hop = (Hop) o;
        return noble == hop.noble && hopName.equals(hop.hopName) && Objects.equals(hopPurpose, hop.hopPurpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hopName, hopPurpose, noble);
    }

    @Override
    public String toString() {
        return "Hop{" +
                "id='" + id + '\'' +
                ", hopName='" + hopName + '\'' +
                ", alphaAcidLowerBound=" + alphaAcidLowerBound +
                ", alphaAcidUpperBound=" + alphaAcidUpperBound +
                ", nominalAlphaAcidPercent=" + nominalAlphaAcidPercent +
                ", hopPurpose='" + hopPurpose + '\'' +
                ", noble=" + noble +
                ", hopStorageIndex=" + hopStorageIndex +
                ", flavorProfile=" + flavorProfile +
                '}';
    }
}