package com.api.domain.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String dimension;

    @ElementCollection
    private List<String> residents;
    private String url;
    private String created;

    
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDimension() {
        return dimension;
    }
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
    public List<String> getResidents() {
        return residents;
    }
    public void setResidents(List<String> residents) {
        this.residents = residents;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getCreated() {
        return created;
    }
    public void setCreated(String created) {
        this.created = created;
    }



    
}
