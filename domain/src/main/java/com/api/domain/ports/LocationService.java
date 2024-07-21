package com.api.domain.ports;

import java.util.List;
import java.util.Optional;

import com.api.domain.model.Location;

public interface LocationService {


    List<Location> getAllLocations();

    Location saveLocation(Location location);

    Optional<Location> getLocationById(Long id);

    void deleteLocation(Long id);
}
