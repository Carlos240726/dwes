package daw2.dwes.morty1.controller;

import daw2.dwes.morty1.dto.CharacterDTO;
import daw2.dwes.morty1.model.Episode;
import daw2.dwes.morty1.model.Location;
import daw2.dwes.morty1.repository.EpisodeRepository;
import daw2.dwes.morty1.repository.LocationRepository;
import daw2.dwes.morty1.service.CharacterService;
import daw2.dwes.morty1.service.EpisodeService;
import daw2.dwes.morty1.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import daw2.dwes.morty1.model.Character;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService service;
    private final LocationService locationService;
    private final EpisodeService episodeService;

    public CharacterController(CharacterService service, LocationService locationService, EpisodeService episodeService) {
        this.service = service;
        this.locationService = locationService;
        this.episodeService = episodeService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("characters", service.findAll());
        return "characters/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {

        Character character = service.findById(id);

        if (character == null) {
            return "redirect:/characters";
        }

        model.addAttribute("character", character);

        return "characters/detail";
    }

    @PostMapping("/delete/{id}")
    public String borrarPersonaje(@PathVariable Long id) {
        service.borrarPersonaje(id);
        return "redirect:/characters";
    }

    @GetMapping("/edit/{id}")
    public String editarPersonaje(@PathVariable Long id, Model model) {
        Character character = service.findById(id);

        CharacterDTO characterDTO = new CharacterDTO();

        characterDTO.setId(character.getId());
        characterDTO.setName(character.getName());
        characterDTO.setStatus(character.getStatus());
        characterDTO.setSpecies(character.getSpecies());
        characterDTO.setType(character.getType());
        characterDTO.setGender(character.getGender());
        characterDTO.setImage(character.getImage());
        characterDTO.setWeight(character.getWeight());
        characterDTO.setHeight(character.getHeight());

        characterDTO.setLocation_id(character.getLocation().getId());

        characterDTO.setEpisodes_id(
                character.getEpisodes().stream()
                        .map(Episode::getId)
                        .collect(Collectors.toSet())
        );

        model.addAttribute("character", characterDTO);
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("episodes", episodeService.findAll());

        return "characters/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute CharacterDTO characterDTO) {
        Character character;

        if (characterDTO.getId() != null) {
            character = service.findById(characterDTO.getId());
        } else {
            character = new Character();
        }

        character.setName(characterDTO.getName());
        character.setStatus(characterDTO.getStatus());
        character.setSpecies(characterDTO.getSpecies());
        character.setType(characterDTO.getType());
        character.setGender(characterDTO.getGender());
        character.setImage(characterDTO.getImage());
        character.setWeight(characterDTO.getWeight());
        character.setHeight(characterDTO.getHeight());

        Location location = locationService.findById(characterDTO.getLocation_id());
        character.setLocation(location);

        Set<Episode> episodes = new HashSet<>();

        if (characterDTO.getEpisodes_id() != null) {
            episodes = characterDTO.getEpisodes_id().stream()
                    .map(id -> episodeService.findById(id))
                    .collect(Collectors.toSet());
        }

        character.setEpisodes(episodes);

        for (Episode episode : episodes) {
            episode.getCharacters().add(character);
        }

        character.setEpisodes(episodes);

        service.initializaCharacter(character);

        return "redirect:/characters";
    }

    @GetMapping("/create")
    public String mostrarFormulario(Model model) {
        model.addAttribute("character", new CharacterDTO());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("episodes", episodeService.findAll());

        return "characters/formulario";
    }
}