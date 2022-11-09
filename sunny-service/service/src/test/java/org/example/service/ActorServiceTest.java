package org.example.service;

import lombok.AllArgsConstructor;
import org.example.repository.ActorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@AllArgsConstructor
class ActorServiceTest {

    @Mock
    private final ActorRepository actorRepository;
    @Mock
    private final ModelMapper modelMapper;

    @InjectMocks
    private final ActorService actorService;

    @Test
    void findById() {

    }

    @Test
    void editActorEntity() {
    }

    @Test
    void createActorByName() {
    }

    @Test
    void findActorsOrCreateAndReturnAsList() {
    }

    @Test
    void getAllActors() {
    }

    @Test
    void deleteActorById() {
    }
}