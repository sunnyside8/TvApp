package com.example.tvservice.controller;

import com.example.tvservice.model.FilmEntity;
import com.example.tvservice.repository.FilmRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/{id}")
    public FilmEntity getFilmById(@PathVariable String id){
        return filmRepository.findById(id).orElseThrow();
    }

}
