package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.entity.ActorEntity;
import org.example.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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

    public List<ActorEntity> findActorsOrCreateThemAndReturnAsList(String actors) {
       return Arrays.stream(actors.split(", "))
               .map(actorName -> actorRepository.findActorEntityByName(actorName)
                       .orElse(actorRepository.save(new ActorEntity().setName(actorName))))
               .collect(Collectors.toList());

    }
}
