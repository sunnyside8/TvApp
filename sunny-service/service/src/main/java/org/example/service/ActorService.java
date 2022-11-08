package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.edit.ActorEditModel;
import org.example.model.entity.ActorEntity;
import org.example.model.view.ActorViewModel;
import org.example.repository.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public ActorEntity editActorEntity(ActorEditModel actorEditModel) {
        ActorEntity actorEntity = actorRepository.findById(actorEditModel.getId())
                .orElseThrow(() -> new IllegalArgumentException("Actor not found"));
        actorEntity.setBirthday(LocalDate.parse(actorEditModel.getBirthday()))
                .setPictureUrl(actorEditModel.getPictureUrl())
                .setApproved(false);

        return actorRepository.save(actorEntity);
    }

    public ActorEntity createActorByName(String actorName){
        return actorRepository.save(new ActorEntity().setName(actorName));
    }

    public List<ActorEntity> findActorsOrCreateAndReturnAsList(String actors) {
       return Arrays.stream(actors.split(", "))
               .map(actorName -> actorRepository.findActorEntityByName(actorName)
                       .orElse(createActorByName(actorName)))
               .collect(Collectors.toList());

    }

    public List<ActorViewModel> getAllActors() {
        return actorRepository.findActorEntitiesByApprovedTrue()
                .stream().map(actor -> modelMapper.map(actor, ActorViewModel.class))
                .collect(Collectors.toList());
    }

    public void deleteActorById(String id) {
        actorRepository.deleteById(id);
    }
}
