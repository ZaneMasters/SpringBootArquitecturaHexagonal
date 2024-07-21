package com.api.domain.ports;

import org.springframework.data.repository.CrudRepository;

import com.api.domain.model.Characters;

public interface CharacterRepository extends CrudRepository<Characters, Long>{

}
