package com.api.infrastructure.dto;

import java.util.List;

public class CharacterDTO {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private OriginDTO origin;
    private LocationDTO location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

    // Getters and setters

    

    public static class OriginDTO {
        private String name;
        private String url;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }

        // Getters and setters
        
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public OriginDTO getOrigin() {
        return origin;
    }

    public void setOrigin(OriginDTO origin) {
        this.origin = origin;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
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

    public static class LocationDTO {
        private String name;
        private String url;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }

        // Getters and setters

        
    }
}
