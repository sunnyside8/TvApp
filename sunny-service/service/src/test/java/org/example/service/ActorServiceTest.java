package org.example.service;

import org.example.model.edit.ActorEditModel;
import org.example.model.entity.ActorEntity;;
import org.example.model.view.ActorViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.example.repository.ActorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActorServiceTest {

    @Mock
    ActorRepository actorRepository;
    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    ActorService actorService;

    ActorEntity actorEntity;
    ActorViewModel actorViewModel;
    ActorEditModel actorEditModel;

    @BeforeEach
    public void setUp() {
        actorEntity = new ActorEntity();
        actorEntity.setId("Edno");
        actorEntity.setName("Aktiorsko Ime");
        actorEntity.setBirthday(LocalDate.of(1999,9,9));

        actorViewModel = new ActorViewModel();
        actorViewModel.setName("Aktiorsko Ime");
        actorViewModel.setId("Edno");
        actorViewModel.setBirthday(LocalDate.of(1999,9,9));

        actorEditModel = new ActorEditModel();
        actorEditModel.setId("Edno");
        actorEditModel.setBirthday("1995-07-07");
    }

    @Test
    void findActorEntityById_okay() {
        when(actorRepository.findById("638")).thenReturn(Optional.of(actorEntity));
        //  when(modelMapper.map(any(ActorEntity.class), ActorViewModel.class)).thenReturn(any(ActorViewModel.class));
        assertEquals(actorEntity, actorService.findActorEntityById("638"));

    }

    @Test
    void findActorEntityById_throws() {
        when(actorRepository.findById("Edno")).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class,
                () -> actorService.findActorEntityById("Edno"));

    }

    @Test
    void editActorEntity() {
        when(actorRepository.findById("Edno")).thenReturn(Optional.of(actorEntity));
        actorEntity.setName("Novo Ime");
        actorEntity.setBirthday(LocalDate.of(1995,7,7));
        when(actorRepository.save(actorEntity)).thenReturn(actorEntity);

        assertEquals(actorService.editActorEntity(actorEditModel),actorEntity);

    }

    @Test
    void createActorByName() {
        when(actorRepository.save(new ActorEntity().setName("Aktiorsko Ime"))).thenReturn(actorEntity);
        assertEquals(actorEntity,
                actorService.createActorByName("Aktiorsko Ime"));
    }

    @Test
    void findActorsOrCreateAndReturnAsList() {
        when(actorRepository.findActorEntityByName("Aktiorsko Ime")).thenReturn(Optional.of(actorEntity));

        assertEquals(List.of(actorEntity),
                actorService.findActorsOrCreateAndReturnAsList("Aktiorsko Ime"));

    }

    @Test
    void getAllActors() {
        when(actorRepository.findActorEntitiesByApprovedTrue()).thenReturn(List.of(actorEntity));
        when(modelMapper.map(actorEntity, ActorViewModel.class)).thenReturn(actorViewModel);

        assertEquals(List.of(actorViewModel), actorService.getAllActors());

    }

    @Test
    void getAllActors_emptyList() {
        when(actorRepository.findActorEntitiesByApprovedTrue()).thenReturn(new ArrayList<>());

        assertEquals(new ArrayList<>(), actorService.getAllActors());

    }

    @Test
    void deleteActorById() {

    }
}