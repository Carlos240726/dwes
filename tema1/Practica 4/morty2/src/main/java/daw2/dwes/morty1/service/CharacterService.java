package daw2.dwes.morty1.service;

import daw2.dwes.morty1.repository.CharacterRepository;
import daw2.dwes.morty1.model.Character;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<Character> findAll() {
        return repository.findAll();
    }

    public Character findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void borrarPersonaje(Long id) {
        repository.borrarPersonaje(id);
    }

    @Transactional
    public void insertarPersonaje(
            String name,
            String status,
            String species,
            String type,
            String gender,
            Long locationId,
            String image,
            Float weight,
            Float height) {

        repository.insertarPersonaje(
                name,
                status,
                species,
                type,
                gender,
                locationId,
                image,
                weight,
                height
        );
    }
}