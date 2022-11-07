package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.model.binding.CinematicBindingModel;
import org.example.service.FilmService;
import org.example.service.ShowtimeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class CinematicController {

    private final FilmService filmService;
    private final ShowtimeService showtimeService;

    @GetMapping("/create")
    public String createAFilm() {
        return "add-cinamtic";
    }

    @PostMapping("/create")
    public String creatingAFilm(@Valid CinematicBindingModel cinematicBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("cinematicBindingModel", cinematicBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.cinematicBindingModel", bindingResult);

            return "redirect:/create";
        }

        if (cinematicBindingModel.getType().equals("Film")) {
            filmService.createFilm(cinematicBindingModel);
        } else if (cinematicBindingModel.getType().equals("Series")) {
            showtimeService.createShowtime(cinematicBindingModel);
        } else {
            throw new IllegalArgumentException("Not valid input");
        }
        return "redirect:/";

    }

    @ModelAttribute("cinematicBindingModel")
    public CinematicBindingModel cinematicBindingModel() {
        return new CinematicBindingModel();
    }


}
