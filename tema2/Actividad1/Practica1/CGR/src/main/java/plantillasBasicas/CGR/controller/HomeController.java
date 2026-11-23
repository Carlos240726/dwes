package plantillasBasicas.CGR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("iniciado", PeliculaController.isIniciado());
        model.addAttribute("totalPeliculas", PeliculaController.getPeliculas().size());
        return "home";
    }
}