package com.api.infrastructure.adapters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.api.domain.model.Location;
import com.api.domain.ports.LocationRepository;
import com.api.infrastructure.dto.LocationDTO;

@Component
public class LocationAdapter {

    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;
    private final LocationRepository locationRepository;
    private static final String API_URL = "https://rickandmortyapi.com/api/location";

    public LocationAdapter(RestTemplate restTemplate, ModelMapper modelMapper, LocationRepository locationRepository) {
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
        this.locationRepository = locationRepository;
    }

    public List<Location> fetchAndSaveAllLocations() {
        LocationResponse locationResponse = restTemplate.getForObject(API_URL, LocationResponse.class);
        List<LocationDTO> locationDTOs = locationResponse.getResults();
        List<Location> locations = locationDTOs.stream()
                                               .map(dto -> modelMapper.map(dto, Location.class))
                                               .collect(Collectors.toList());
        locations.forEach(locationRepository::save);
        return locations;
    }

    private static class LocationResponse {
        private List<LocationDTO> results;

        public List<LocationDTO> getResults() {
            return results;
        }

        public void setResults(List<LocationDTO> results) {
            this.results = results;
        }
    }
}
