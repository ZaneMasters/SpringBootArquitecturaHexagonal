package com.api.domain.ports;

import java.util.List;
import java.util.Optional;

import com.api.domain.model.Characters;

public interface CharacterService {

    List<Characters> getAllCharacters();

    Characters saveCharacter(Characters character);

    Optional<Characters> getCharacterById(Long id);

    void deleteCharacter(Long id);
}
