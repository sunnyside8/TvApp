package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.model.entity.FilmEntity;
import org.example.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public String createAFilm(){
        return "add-film";
    }

//
//    @GetMapping("/{id}")
//    public FilmEntity getFilmById(@PathVariable String id){
//        return fi.findById(id).orElseThrow();
//    }
//
//    @PostMapping
//    public FilmEntity createFilm(@RequestBody FilmEntity film){
//
//        return filmRepository.save(film);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteFilm(@PathVariable String id){
//        filmRepository.deleteById(id);
//        return "Success";
//    }

}
