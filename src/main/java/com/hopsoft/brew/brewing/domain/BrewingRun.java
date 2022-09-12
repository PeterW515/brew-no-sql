package com.hopsoft.brew.brewing.domain;

import com.hopsoft.brew.brewing.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

@Document
public class BrewingRun {

    @Id
    private String id;

    private String runName;

    @DBRef
    private Recipe recipe;

    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    private Status status;

    public BrewingRun(){};

    public BrewingRun(String runName, Recipe recipe, ZonedDateTime startTime, ZonedDateTime endTime, Status status) {
        this.runName = runName;
        this.recipe = recipe;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRunName() {
        return runName;
    }

    public void setRunName(String runName) {
        this.runName = runName;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrewingRun that = (BrewingRun) o;
        return id.equals(that.id) && Objects.equals(runName, that.runName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, runName);
    }

    @Override
    public String toString() {
        return "BrewingRun{" +
                "id='" + id + '\'' +
                ", runName='" + runName + '\'' +
                ", recipe=" + recipe +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}
