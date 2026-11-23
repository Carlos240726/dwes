package daw2.dwes.morty1.controller;

import daw2.dwes.morty1.dto.LocationDTO;
import daw2.dwes.morty1.model.Character;
import daw2.dwes.morty1.model.Location;
import daw2.dwes.morty1.service.CharacterService;
import daw2.dwes.morty1.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/locations")
public class LocationController {

    private final LocationService service;
    private final CharacterService characterService;

    public LocationController(LocationService service, CharacterService characterService) {
        this.service = service;
        this.characterService = characterService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("locations", service.findAll());
        return "locations/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("location", service.findById(id));
        return "locations/detail";
    }

    @GetMapping("update/{id}")
    public String actualizarNombre(
            @PathVariable Long id,
            @RequestParam String name) {

        service.actualizarNombre(id, name);

        return "redirect:/locations/" + id;
    }

    @GetMapping("/crearte-with-character")
    public String crearConPersonaje(
            @RequestParam String locationName,
            @RequestParam String locationType,
            @RequestParam String dimension,
            @RequestParam String characterName,
            @RequestParam String status,
            @RequestParam String species,
            @RequestParam String type,
            @RequestParam String gender,
            @RequestParam String image,
            @RequestParam Float weight,
            @RequestParam Float height) {

        Long locationId = service.insertarLocalizacion(
                locationName,
                locationType,
                dimension
        );

        characterService.insertarPersonaje(
                characterName,
                status,
                species,
                type,
                gender,
                locationId,
                image,
                weight,
                height
        );

        return "redirect:/locations";
    }
    @GetMapping("/create")
    public String mostrarFormulario(Model model){
        model.addAttribute("location", new LocationDTO());
        model.addAttribute("characters", characterService.findAll());
        return "locations/formulario";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute LocationDTO locationDTO){
        Location location;

        if(locationDTO.getId() != null){
            location = service.findById(locationDTO.getId());
        }else {
            location = new Location();
        }

        new Location();
        location.setName(locationDTO.getName());
        location.setType(locationDTO.getType());
        location.setDimension(locationDTO.getDimension());
        Set<Character> characters = locationDTO.getCharacters().stream()
                .map(character -> characterService.findById(character.getId()))
                .collect(Collectors.toSet());
        for(Character character : characters){
            character.setLocation(location);
        }
        location.setCharacters(characters);
        service.save(location);
        return "redirect:/locations";
    }

    @GetMapping("/edit/{id}")
    public String editarLocalizacion(@PathVariable Long id, Model model){
        Location location = service.findById(id);

        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setCharacters(location.getCharacters());
        locationDTO.setDimension(location.getDimension());
        locationDTO.setId(location.getId());
        locationDTO.setName(location.getName());
        locationDTO.setType(location.getType());
        model.addAttribute("location", locationDTO);
        model.addAttribute("characters", characterService.findAll());
        return "locations/formulario";
    }

    @GetMapping("/delete/{id}")
    public String borrarLocation(@PathVariable Long id){
        service.delete(id);
        return "redirect:/locations";
    }
}