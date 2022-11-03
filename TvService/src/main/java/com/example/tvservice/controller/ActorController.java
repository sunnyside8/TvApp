package com.example.tvservice.controller;

import com.example.tvservice.model.ActorEntity;
import com.example.tvservice.repository.ActorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorRepository actorRepository;


    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping("/{id}")
    public ActorEntity getActorById(@PathVariable String id){
        return actorRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public ActorEntity createActor(@RequestBody ActorEntity actor){
        return actorRepository.save(actor);
    }
}
