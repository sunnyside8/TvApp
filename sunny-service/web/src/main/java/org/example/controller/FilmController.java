package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class FilmController {

    @GetMapping("/all")
    public String allMovies(){
        return "";
    }
}
