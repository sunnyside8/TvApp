package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.binding.EpisodeBindingModel;
import org.example.service.ShowtimeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @GetMapping("/{id}/episodes/create")
    public String createEpisodeForShow(@PathVariable String id,Model model){
        if(!model.containsAttribute("showtimeId")){
            model.addAttribute("showtimeId",id);
        }
        return "add-episode";
    }

    @PostMapping("/{id}/episodes/create")
    public String createEpisode(@Valid EpisodeBindingModel episodeBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, @PathVariable String id){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("episodeBindingModel", episodeBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.episodeBindingModel", bindingResult);

            return "redirect:/showtimes/{id}/episodes/create";
        }

        showtimeService.createEpisodeForShowtimeWithId(id,episodeBindingModel);

        return "redirect:/";
    }

    @ModelAttribute("episodeBindingModel")
    public EpisodeBindingModel episodeBindingModel(){
        return new EpisodeBindingModel();
    }
}
