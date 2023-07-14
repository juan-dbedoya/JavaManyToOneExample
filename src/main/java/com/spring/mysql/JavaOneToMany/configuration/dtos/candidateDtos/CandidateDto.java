package com.spring.mysql.JavaOneToMany.configuration.dtos.candidateDtos;

import com.spring.mysql.JavaOneToMany.configuration.dtos.careerDtos.GatCareerDto;

public class CandidateDto {
    private Long id;
    private String name;
    private Integer age;
    private String cv;
    private GatCareerDto career;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public GatCareerDto getCareer() {
        return career;
    }

    public void setCareer(GatCareerDto career) {
        this.career = career;
    }
}
