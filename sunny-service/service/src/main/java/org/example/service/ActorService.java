package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.entity.ActorEntity;
import org.example.model.view.ActorViewModel;
import org.example.repository.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;
    private final ModelMapper modelMapper;


    public ActorEntity findById(String id) {
       return actorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entity with this id not found"));
    }

    public ActorEntity updateActor(ActorEntity actor) {
        return actorRepository.save(actor);
    }

    public List<ActorEntity> findActorsOrCreateAndReturnAsList(String actors) {
       return Arrays.stream(actors.split(", "))
               .map(actorName -> actorRepository.findActorEntityByName(actorName)
                       .orElse(actorRepository.save(new ActorEntity().setName(actorName))))
               .collect(Collectors.toList());

    }

    public List<ActorViewModel> getAllActors() {
        return actorRepository.findActorEntitiesByApprovedTrue()
                .stream().map(actor -> modelMapper.map(actor, ActorViewModel.class))
                .collect(Collectors.toList());
    }
}
