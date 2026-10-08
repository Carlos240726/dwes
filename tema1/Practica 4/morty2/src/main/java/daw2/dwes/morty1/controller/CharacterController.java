package daw2.dwes.morty1.controller;

import daw2.dwes.morty1.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import daw2.dwes.morty1.model.Character;

@Controller
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
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

    @DeleteMapping("/delete/{id}")
    public String borrarPersonaje(@PathVariable Long id) {
        service.borrarPersonaje(id);
        return "redirect:/characters";
    }
}