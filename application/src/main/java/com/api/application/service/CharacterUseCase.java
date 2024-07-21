package com.api.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.domain.model.Characters;
import com.api.domain.ports.CharacterRepository;
import com.api.domain.ports.CharacterService;

@Service
public class CharacterUseCase implements CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterUseCase(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Characters> getAllCharacters() {
        return (List<Characters>) characterRepository.findAll();
    }

    @Override
    public Characters saveCharacter(Characters character) {
        return characterRepository.save(character);
    }

    @Override
    public Optional<Characters> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    @Override
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
}
