package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.model.binding.FilmBindingModel;
import org.example.model.entity.FilmEntity;
import org.example.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {

    private final FilmService filmService;

//    @GetMapping("/create")
//    public String createAFilm(){
//        return "add-film";
//    }
//
//    @PostMapping("/create")
//    public String creatingAFilm(@Valid FilmBindingModel filmBindingModel,
//                                BindingResult bindingResult,
//                                RedirectAttributes redirectAttributes){
//        if(bindingResult.hasErrors()){
//            redirectAttributes.addFlashAttribute("registrationBinding",filmBindingModel);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.filmBindingModel",bindingResult);
//
//            return "redirect:/films/create";
//        }
//
//        System.out.println(filmBindingModel.toString());
//        return "add-film";
//
//    }
//
//    @ModelAttribute("filmBindingModel")
//    public FilmBindingModel userRegistrationBinding(){
//        return new FilmBindingModel();
//    }
//
//    @GetMapping("/{id}")
//    public FilmEntity getFilmById(@PathVariable String id){
//        return fi.findById(id).orElseThrow();
//    }
//
    @PostMapping
    public String createFilm(@RequestBody @Valid FilmBindingModel film, Errors errors){
        if (errors.hasErrors()) {
            throw new IllegalArgumentException(errors.getFieldErrors().get(0).getDefaultMessage());
        }

        return filmService.createFilm(film);
    }
//
//    @DeleteMapping("/{id}")
//    public String deleteFilm(@PathVariable String id){
//        filmRepository.deleteById(id);
//        return "Success";
//    }

}
