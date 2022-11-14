package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.service.ShowtimeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/showtimes")
@AllArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    @GetMapping
    public String allShowtimes(Model model){
        if(!model.containsAttribute("showtimes")) {
            model.addAttribute("showtimes", showtimeService.getAllApprovedShowtimes());
        }
        return "all-showtimes";
    }

    @GetMapping("/{id}/full-info")
    public String getFullInfoOfShowById(@PathVariable String id,Model model){
        model.addAttribute("showtime",showtimeService.getShowtimeFullViewModelById(id));
    return "showtime-page";
    }
}
