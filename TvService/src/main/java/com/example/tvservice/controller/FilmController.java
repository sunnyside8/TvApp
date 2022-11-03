package com.example.tvservice.controller;

import com.example.tvservice.model.FilmEntity;
import com.example.tvservice.repository.ActorRepository;
import com.example.tvservice.repository.FilmRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmRepository filmRepository;
    private final ActorRepository actorRepository;

    public FilmController(FilmRepository filmRepository, ActorRepository actorRepository) {
        this.filmRepository = filmRepository;
        this.actorRepository = actorRepository;
    }

    @GetMapping("/{id}")
    public FilmEntity getFilmById(@PathVariable String id){
        return filmRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public FilmEntity createFilm(@RequestBody FilmEntity film){

        return filmRepository.save(film);
    }

}
