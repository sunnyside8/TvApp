package org.example.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {

//    private final FilmRepository filmRepository;
//    private final ActorRepository actorRepository;
//
//    @GetMapping("/{id}")
//    public FilmEntity getFilmById(@PathVariable String id){
//        return filmRepository.findById(id).orElseThrow();
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
