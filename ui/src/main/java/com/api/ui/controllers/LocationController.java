package com.api.ui.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.application.service.LocationUseCase;
import com.api.domain.model.Location;
import com.api.infrastructure.adapters.LocationAdapter;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationUseCase locationUseCase;
    private final LocationAdapter locationAdapter;

    public LocationController(LocationUseCase locationUseCase, LocationAdapter locationAdapter) {
        this.locationUseCase = locationUseCase;
        this.locationAdapter = locationAdapter;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationUseCase.getAllLocations();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationUseCase.saveLocation(location);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        return locationUseCase.getLocationById(id)
                              .map(ResponseEntity::ok)
                              .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationUseCase.deleteLocation(id);
    }

    @GetMapping("/fetch")
    public List<Location> fetchAndSaveAllLocations() {
        return locationAdapter.fetchAndSaveAllLocations();
    }
}