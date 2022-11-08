package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public String allMovies(Model model){
        if(!model.containsAttribute("films")) {
            model.addAttribute("films", filmService.getAllApprovedFilms());
        }
        return "all-films";
    }


}
