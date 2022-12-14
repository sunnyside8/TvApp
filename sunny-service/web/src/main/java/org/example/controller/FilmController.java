package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.entity.EpisodeEntity;
import org.example.model.user.TvAppUser;
import org.example.service.FilmService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public String allFilms(Model model){
        if(!model.containsAttribute("films")) {
            model.addAttribute("films", filmService.getAllApprovedFilms());
        }
        return "all-films";
    }

    @GetMapping("/{id}/full-info")
    public String filmFullView(@PathVariable String id,Model model){
        model.addAttribute("film",filmService.getFilmFullViewModelById(id));
        return "film-page";
    }



}
