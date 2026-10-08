package daw2.dwes.morty1.controller;

import daw2.dwes.morty1.service.EpisodeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/episodes")
public class EpisodeController {

    private final EpisodeService service;

    public EpisodeController(EpisodeService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("episodes", service.findAll());
        return "episodes/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("episode", service.findById(id));
        return "episodes/detail";
    }

    @GetMapping("/create")
    public String insertarEpisode(
            @RequestParam String name,
            @RequestParam String airDate,
            @RequestParam String episodeCode) {

        service.insertarEpisode(name, airDate, episodeCode);
        return "redirect:/episodes";
    }
}