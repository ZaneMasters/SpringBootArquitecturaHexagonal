package com.api.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.domain.model.Location;
import com.api.domain.ports.LocationRepository;
import com.api.domain.ports.LocationService;

@Service
public class LocationUseCase implements LocationService {

    private final LocationRepository locationRepository;

    public LocationUseCase(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
