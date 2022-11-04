package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.entity.ActorEntity;
import org.example.repository.ActorRepository;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;


    public ActorEntity findById(String id) {
       return actorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entity with this id not found"));
    }

    public ActorEntity updateActor(ActorEntity actor) {
        return actorRepository.save(actor);
    }
}
