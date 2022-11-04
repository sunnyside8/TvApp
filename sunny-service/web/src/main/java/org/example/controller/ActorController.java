package org.example.controller;


import org.example.service.ActorService;
import org.example.model.entity.ActorEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorController {

  private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/{id}")
    public ActorEntity getActorById(@PathVariable String id){
        return actorService.findById(id);
    }

    @PostMapping
    public ActorEntity createActor(@RequestBody ActorEntity actor){
        return actorService.updateActor(actor);
    }

//    @PutMapping
//    public ActorEntity updateActor(@RequestBody ActorEntity actor){
//        return actorRepository.save(actor);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteActor(@PathVariable String id){
//        actorRepository.deleteById(id);
//        return "Success";
//    }
}
