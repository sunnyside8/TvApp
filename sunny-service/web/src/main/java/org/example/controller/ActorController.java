package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.model.edit.ActorEditModel;
import org.example.service.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @GetMapping("/edit/{id}")
    public String editActor(@PathVariable String id,Model model){
        ActorEditModel actorEditModel = new ActorEditModel();
        actorEditModel.setId(id);
        model.addAttribute("actorEditModel",actorEditModel);
        return "edit-actor";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedActor( @Valid ActorEditModel actorEditModel,@PathVariable String id,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("actorEditModel",actorEditModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.actorEditModel",bindingResult);

            return "redirect:/edit/{id}";
        }

        actorEditModel.setId(id);
        actorService.editActorEntity(actorEditModel);

        return "redirect:/actors";
    }

    @GetMapping("/delete/{id}")
    public String deleteActor(@PathVariable String id){
        actorService.deleteActorById(id);
        return "redirect:/actors";
    }

}
