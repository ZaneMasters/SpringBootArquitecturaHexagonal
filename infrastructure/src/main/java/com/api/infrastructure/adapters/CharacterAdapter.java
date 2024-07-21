package com.api.infrastructure.adapters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.api.domain.model.Characters;
import com.api.domain.ports.CharacterRepository;
import com.api.infrastructure.dto.CharacterDTO;

@Component
public class CharacterAdapter {

    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;
    private final CharacterRepository characterRepository;
    private static final String API_URL = "https://rickandmortyapi.com/api/character";

    public CharacterAdapter(RestTemplate restTemplate, ModelMapper modelMapper, CharacterRepository characterRepository) {
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
        this.characterRepository = characterRepository;
    }

    public List<Characters> fetchAndSaveAllCharacters() {
        CharacterResponse characterResponse = restTemplate.getForObject(API_URL, CharacterResponse.class);
        List<CharacterDTO> characterDTOs = characterResponse.getResults();
        List<Characters> characters = characterDTOs.stream()
                                                  .map(dto -> modelMapper.map(dto, Characters.class))
                                                  .collect(Collectors.toList());
        characters.forEach(characterRepository::save);
        return characters;
    }

    private static class CharacterResponse {
        private List<CharacterDTO> results;

        public List<CharacterDTO> getResults() {
            return results;
        }

        public void setResults(List<CharacterDTO> results) {
            this.results = results;
        }
    }
}