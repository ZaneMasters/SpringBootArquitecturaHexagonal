package com.api.infrastructure.adapters;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    private final CharacterAdapter characterAdapter;
    private final LocationAdapter locationAdapter;

    public DataLoader(CharacterAdapter characterAdapter, LocationAdapter locationAdapter) {
        this.characterAdapter = characterAdapter;
        this.locationAdapter = locationAdapter;
    }

    @PostConstruct
    public void loadData() {
        characterAdapter.fetchAndSaveAllCharacters();
        locationAdapter.fetchAndSaveAllLocations();
    }
}
