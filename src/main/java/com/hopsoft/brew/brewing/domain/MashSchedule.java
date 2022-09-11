package com.hopsoft.brew.brewing.domain;

import com.hopsoft.brew.brewing.enums.InfusionType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class MashSchedule {
    @Id
    private String id;

private InfusionType infusionType;
@DBRef
private List<MashRest> mashRests;

    public MashSchedule(InfusionType infusionType, List<MashRest> mashRests) {
        this.infusionType = infusionType;
        this.mashRests = mashRests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InfusionType getInfusionType() {
        return infusionType;
    }

    public void setInfusionType(InfusionType infusionType) {
        this.infusionType = infusionType;
    }

    public List<MashRest> getMashRests() {
        return mashRests;
    }

    public void setMashRests(List<MashRest> mashRests) {
        this.mashRests = mashRests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MashSchedule that = (MashSchedule) o;
        return id.equals(that.id) && infusionType == that.infusionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, infusionType);
    }

    @Override
    public String toString() {
        return "MashSchedule{" +
                "id='" + id + '\'' +
                ", infusionType=" + infusionType +
                ", mashRests=" + mashRests +
                '}';
    }
}
