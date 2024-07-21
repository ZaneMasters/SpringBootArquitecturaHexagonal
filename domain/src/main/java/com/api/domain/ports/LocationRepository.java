package com.api.domain.ports;

import org.springframework.data.repository.CrudRepository;

import com.api.domain.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long>{

}
