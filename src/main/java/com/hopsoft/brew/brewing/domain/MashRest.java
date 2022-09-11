package com.hopsoft.brew.brewing.domain;

import com.hopsoft.brew.brewing.enums.RestType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class MashRest {
@Id
    private String id;

    private RestType restType;

    private Double temperature;

    private Double duration;

    public MashRest(RestType restType, Double temperature, Double duration) {
        this.restType = restType;
        this.temperature = temperature;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestType getRestType() {
        return restType;
    }

    public void setRestType(RestType restType) {
        this.restType = restType;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MashRest mashRest = (MashRest) o;
        return id.equals(mashRest.id) && Objects.equals(temperature, mashRest.temperature) && Objects.equals(duration, mashRest.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temperature, duration);
    }

    @Override
    public String toString() {
        return "MashRest{" +
                "id='" + id + '\'' +
                ", restType=" + restType +
                ", temperature=" + temperature +
                ", duration=" + duration +
                '}';
    }
}
