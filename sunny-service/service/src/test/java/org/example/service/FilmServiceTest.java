package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.example.model.binding.CinematicBindingModel;
import org.example.model.entity.ActorEntity;
import org.example.model.entity.FilmEntity;
import org.example.model.enums.GenreEnum;
import org.example.model.view.ActorViewModel;
import org.example.model.view.FilmFullViewModel;
import org.example.model.view.FilmModalViewModel;
import org.example.repository.FilmRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class FilmServiceTest {
    @Mock
    FilmRepository filmRepository;

    @Mock
    ModelMapper modelMapper;

    @Mock
    ActorService actorService;

    @InjectMocks
    FilmService filmService;

    FilmEntity filmEntity;
    CinematicBindingModel cinematicBindingModel;
    FilmFullViewModel filmFullViewModel;
    FilmModalViewModel filmModalViewModel;
    ActorEntity actorEntity;
    ActorViewModel actorViewModel;

    @BeforeEach
    public void setUp() {
        actorEntity = new ActorEntity();
        actorEntity.setId("Edno");
        actorEntity.setName("Aktiorsko Ime");
        actorEntity.setBirthday(LocalDate.of(1999, 9, 9));

        actorViewModel = new ActorViewModel();
        actorViewModel.setName("Aktiorsko Ime");
        actorViewModel.setId("Edno");
        actorViewModel.setBirthday(LocalDate.of(1999, 9, 9));

        filmEntity = new FilmEntity();
        filmEntity.setId("636b69d1da07d11846e5d171");
        filmEntity.setTitle("Filmche");
        filmEntity.setImgUrl("https://pbs.twimg.com/media/Fbrr88FXgAADzHN?format=jpg&name=large");
        filmEntity.setYearOfRelease(2000);
        filmEntity.setGenres(List.of(GenreEnum.Adventure));
        filmEntity.setActors(List.of(actorEntity));
        filmEntity.setRating(8);
        filmEntity.setDescription("Nearly 5,000 years after he was bestowed with the almighty powers of the ancient " +
                "gods--and imprisoned just as quickly--Black Adam (Dwayne Johnson) is freed from his earthly tomb, " +
                "ready to unleash his unique form of justice on the modern world.");
        filmEntity.setApproved(true);

        cinematicBindingModel = new CinematicBindingModel();
        cinematicBindingModel.setType("film");
        cinematicBindingModel.setTitle("Filmche");
        cinematicBindingModel.setRating(8);
        cinematicBindingModel.setDescription("Nearly 5,000 years after he was bestowed with the almighty powers of the ancient " +
                "gods--and imprisoned just as quickly--Black Adam (Dwayne Johnson) is freed from his earthly tomb, " +
                "ready to unleash his unique form of justice on the modern world.");
        cinematicBindingModel.setActors("Aktiorsko ime");
        cinematicBindingModel.setGenres("Adventure");
        cinematicBindingModel.setImgUrl("https://pbs.twimg.com/media/Fbrr88FXgAADzHN?format=jpg&name=large");

        filmModalViewModel = new FilmModalViewModel();
        filmModalViewModel.setId("636b69d1da07d11846e5d171");
        filmModalViewModel.setTitle("Filmche");
        filmModalViewModel.setYearOfRelease(2000);
        filmModalViewModel.setOneOfTheGenres("Action");
        filmModalViewModel.setDescription("Nearly 5,000 years after he was b...");

        filmFullViewModel = new FilmFullViewModel();
        filmFullViewModel.setId("636b69d1da07d11846e5d171");
        filmFullViewModel.setTitle("Filmche");
        filmFullViewModel.setYearOfRelease(2000);
        filmFullViewModel.setGenres(List.of("Adventure"));
        filmFullViewModel.setActors(List.of(actorViewModel));
        filmFullViewModel.setRating(8);
        filmFullViewModel.setDescription("Nearly 5,000 years after he was bestowed with the almighty powers of the ancient " +
                "gods--and imprisoned just as quickly--Black Adam (Dwayne Johnson) is freed from his earthly tomb, " +
                "ready to unleash his unique form of justice on the modern world.");

    }

    @Test
    void createFilm_okay() {
        when(actorService.findActorsOrCreateAndReturnAsList("Aktiorsko ime")).thenReturn(List.of(actorEntity));
        when(modelMapper.map(cinematicBindingModel,FilmEntity.class)).thenReturn(filmEntity);
        when(filmRepository.save(filmEntity)).thenReturn(filmEntity);

        assertEquals(filmEntity,filmService.createFilm(cinematicBindingModel));
    }

    @Test
    void getAllApprovedFilms_okay() {
        when(filmRepository.getFilmEntitiesByApprovedTrue()).thenReturn(List.of(filmEntity));
        when(modelMapper.map(filmEntity,FilmModalViewModel.class)).thenReturn(filmModalViewModel);

        assertEquals(List.of(filmModalViewModel),filmService.getAllApprovedFilms());
    }

    @Test
    void getFilmEntityById_okay() {
        when(filmRepository.findById("ID")).thenReturn(Optional.of(filmEntity));

        assertEquals(filmEntity,filmService.getFilmEntityById("ID"));

    }

    @Test
    void getFilmEntityById_throws() {
        when(filmRepository.findById("ID")).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                () ->  filmService.getFilmEntityById("ID"));

    }
    @Test
    void getFilmFullViewModelById() {
        when(filmRepository.findById("636b69d1da07d11846e5d171")).thenReturn(Optional.of(filmEntity));
        when(modelMapper.map(filmEntity,FilmFullViewModel.class)).thenReturn(filmFullViewModel);

        assertEquals(filmFullViewModel,filmService.getFilmFullViewModelById("636b69d1da07d11846e5d171"));
    }
}