package daw2.dwes.morty1.controller;

import daw2.dwes.morty1.service.CharacterService;
import daw2.dwes.morty1.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}