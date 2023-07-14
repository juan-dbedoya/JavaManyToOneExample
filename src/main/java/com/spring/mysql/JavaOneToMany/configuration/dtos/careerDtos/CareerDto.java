package com.spring.mysql.JavaOneToMany.configuration.dtos.careerDtos;

import com.spring.mysql.JavaOneToMany.entities.Candidate;

import java.util.List;

public class CareerDto {
    private Long id;
    private String name;
    private String description;
    private Integer capacity;
    private List<Candidate> candidates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }
}
