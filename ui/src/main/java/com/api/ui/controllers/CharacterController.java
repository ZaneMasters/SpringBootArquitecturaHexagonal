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

import com.api.application.service.CharacterUseCase;
import com.api.domain.model.Characters;
import com.api.infrastructure.adapters.CharacterAdapter;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterUseCase characterUseCase;
    private final CharacterAdapter characterAdapter;

    public CharacterController(CharacterUseCase characterUseCase, CharacterAdapter characterAdapter) {
        this.characterUseCase = characterUseCase;
        this.characterAdapter = characterAdapter;
    }

    @GetMapping
    public List<Characters> getAllCharacters() {
        return characterUseCase.getAllCharacters();
    }

    @PostMapping
    public Characters createCharacter(@RequestBody Characters character) {
        return characterUseCase.saveCharacter(character);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Characters> getCharacterById(@PathVariable Long id) {
        return characterUseCase.getCharacterById(id)
                               .map(ResponseEntity::ok)
                               .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterUseCase.deleteCharacter(id);
    }


    //guarda en la base de datos desde la api
    @GetMapping("/fetch")
    public List<Characters> fetchAndSaveAllCharacters() {
        return characterAdapter.fetchAndSaveAllCharacters();
    }
}