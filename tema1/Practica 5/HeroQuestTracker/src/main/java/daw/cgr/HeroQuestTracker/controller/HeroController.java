package daw.cgr.HeroQuestTracker.controller;

import daw.cgr.HeroQuestTracker.model.Hero;
import daw.cgr.HeroQuestTracker.service.HeroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/heroes")
public class HeroController {
    private final HeroService service;
    public HeroController(HeroService service){this.service = service;}

    @GetMapping("/initialize")
    public String initializeHeroes(@RequestParam String name, @RequestParam String clase){
        Hero hero = new Hero();
        hero.setName(name);
        hero.setNivel(1);
        hero.setExperience(0);
        hero.setClase(clase);
        service.initializaHeroes(hero);
        return "redirect://heroes";
    }

    @GetMapping
    public String showHeroes(Model model){
        model.addAttribute("heroes", service.getAllHeroes());
        return "heroes/list";
    }

    @GetMapping("/{name}")
    public String details(@PathVariable String name, Model model){
        model.addAttribute("hero", service.findById(name));
        return "hero/detail";
    }


}
