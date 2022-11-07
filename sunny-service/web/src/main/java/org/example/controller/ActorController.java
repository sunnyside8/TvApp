package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.service.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/actors")
@AllArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public String showAllActors(Model model) {
        if(!model.containsAttribute("actors")) {
            model.addAttribute("actors", actorService.getAllActors());
        }
        return "all-actors";
    }
}
