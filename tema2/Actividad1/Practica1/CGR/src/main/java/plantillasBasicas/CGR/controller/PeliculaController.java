package plantillasBasicas.CGR.controller;

import plantillasBasicas.CGR.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    private static final List<Pelicula> peliculas = new ArrayList<>();
    private static boolean iniciado = false;

    public static List<Pelicula> getPeliculas() {
        return Collections.unmodifiableList(peliculas);
    }

    public static boolean isIniciado() {
        return iniciado;
    }

    @GetMapping("/inicializar")
    public String inicializar() {
        if (!iniciado) {
            peliculas.add(new Pelicula(
                    1L,
                    "Origen",
                    "Ciencia Ficción",
                    8.8f,
                    "https://www.imdb.com/title/tt1375666/",
                    "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg",
                    LocalDate.of(2010, 7, 16)
            ));

            peliculas.add(new Pelicula(
                    2L,
                    "El Caballero Oscuro",
                    "Acción",
                    9.0f,
                    "https://www.imdb.com/title/tt0468569/",
                    "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg",
                    LocalDate.of(2008, 7, 18)
            ));

            peliculas.add(new Pelicula(
                    3L,
                    "Parásitos",
                    "Thriller",
                    8.5f,
                    "https://www.imdb.com/title/tt6751668/",
                    "https://m.media-amazon.com/images/M/MV5BYWZjMjk3ZTItODQ2ZC00NTY5LWE0ZDYtZTI3MjcwN2Q5NTVkXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_.jpg",
                    LocalDate.of(2019, 5, 30)
            ));

            peliculas.add(new Pelicula(
                    4L,
                    "El Viaje de Chihiro",
                    "Animación",
                    8.6f,
                    "https://www.imdb.com/title/tt0245429/",
                    "https://m.media-amazon.com/images/M/MV5BMjlmZmI5MDctNDE2YS00YWE0LWE5ZWItZDBhYWQ0NTQ2NTQ2XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg",
                    LocalDate.of(2001, 7, 20)
            ));

            peliculas.add(new Pelicula(
                    5L,
                    "Interstellar",
                    "Ciencia Ficción",
                    8.7f,
                    "https://www.imdb.com/title/tt0816692/",
                    "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg",
                    LocalDate.of(2014, 11, 7)
            ));

            peliculas.add(new Pelicula(
                    6L,
                    "Pulp Fiction",
                    "Crimen",
                    8.9f,
                    "https://www.imdb.com/title/tt0110912/",
                    "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
                    LocalDate.of(1994, 10, 14)
            ));

            iniciado = true;
        }
        return "redirect:/home";
    }

    @GetMapping
    public String listado(Model model) {
        if (!iniciado) {
            return "redirect:/home";
        }
        model.addAttribute("peliculas", peliculas);
        return "peliculas/listado";
    }

    @GetMapping("/{id}")
    public String detalles(@PathVariable Long id, Model model) {
        if (!iniciado) {
            return "redirect:/home";
        }

        Pelicula encontrada = peliculas.stream()
                .filter(p -> p.getIdentificador().equals(id))
                .findFirst()
                .orElse(null);

        if (encontrada == null) {
            return "redirect:/peliculas";
        }

        model.addAttribute("pelicula", encontrada);
        return "peliculas/detalles";
    }
}