package org.example.service;

import org.example.model.binding.CinematicBindingModel;
import org.example.model.entity.ActorEntity;
import org.example.model.entity.EpisodeEntity;
import org.example.model.entity.ShowtimeEntity;
import org.example.model.enums.GenreEnum;
import org.example.model.view.ActorViewModel;
import org.example.model.view.EpisodeViewModel;
import org.example.model.view.ShowtimeFullViewModel;
import org.example.model.view.ShowtimeModalViewModel;
import org.example.repository.ShowtimeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShowtimeServiceTest {

    @Mock
    ShowtimeRepository showtimeRepository;
    @Mock
    ActorService actorService;
    @Mock
    ModelMapper modelMapper;
    @InjectMocks
    ShowtimeService showtimeService;

    ActorEntity actorEntity;
    ActorViewModel actorViewModel;
    CinematicBindingModel cinematicBindingModel;

    ShowtimeEntity showtimeEntity;
    ShowtimeModalViewModel showtimeModalViewModel;
    ShowtimeFullViewModel showtimeFullViewModel;

    EpisodeEntity episodeEntity;
    EpisodeViewModel episodeViewModel;

    @BeforeEach
    public void setUp(){
        actorEntity = new ActorEntity();
        actorEntity.setId("Edno");
        actorEntity.setName("Aktiorsko Ime");
        actorEntity.setBirthday(LocalDate.of(1999, 9, 9));

        actorViewModel = new ActorViewModel();
        actorViewModel.setName("Aktiorsko Ime");
        actorViewModel.setId("Edno");
        actorViewModel.setBirthday(LocalDate.of(1999, 9, 9));

        episodeEntity = new EpisodeEntity().setId("s1e1").setEpisode(1).setDescription("Pveche ot 5simvla")
                .setSeason(1).setReleaseDate(LocalDate.of(1999, 9, 9))
                .setTitle("Pilot");

        episodeViewModel= new EpisodeViewModel().setId("s1e1").setTitle("Pilot");

        cinematicBindingModel = new CinematicBindingModel();
        cinematicBindingModel.setType("Series");
        cinematicBindingModel.setTitle("Serialche");
        cinematicBindingModel.setRating(8);
        cinematicBindingModel.setDescription("A scrappy, feisty, fiercely loyal Chicago family makes no apologies.");
        cinematicBindingModel.setActors("Aktiorsko ime");
        cinematicBindingModel.setGenres("Comedy, Drama");
        cinematicBindingModel.setImgUrl("https://pbs.twimg.com/media/Fbrr88FXgAADzHN?format=jpg&name=large");

        showtimeEntity = new ShowtimeEntity();
        showtimeEntity.setId("63692ff4f52e5a193d18a43a");
        showtimeEntity.setTitle("Serialche");
        showtimeEntity.setImgUrl("https://pbs.twimg.com/media/Fbrr88FXgAADzHN?format=jpg&name=large");
        showtimeEntity.setGenres(List.of(GenreEnum.Comedy,GenreEnum.Drama));
        showtimeEntity.setActors(List.of(actorEntity));
        showtimeEntity.setRating(8);
        showtimeEntity.setDescription("A scrappy, feisty, fiercely loyal Chicago family makes no apologies.");
        showtimeEntity.setApproved(false);
        showtimeEntity.setEpisodes(List.of(episodeEntity));

        showtimeModalViewModel = new ShowtimeModalViewModel();
        showtimeModalViewModel.setId("63692ff4f52e5a193d18a43a");
        showtimeModalViewModel.setTitle("Serialche");
        showtimeModalViewModel.setImgUrl("https://pbs.twimg.com/media/Fbrr88FXgAADzHN?format=jpg&name=large");
        showtimeModalViewModel.setOneOfTheGenres("Comdey");
        showtimeModalViewModel.setDescription("A scrappy, feisty, fiercely loyal");
        showtimeModalViewModel.setNumberOfEpisodes(1);

        showtimeFullViewModel = new ShowtimeFullViewModel();
        showtimeFullViewModel.setId("63692ff4f52e5a193d18a43a");
        showtimeFullViewModel.setTitle("Serialche");
        showtimeFullViewModel.setImgUrl("https://pbs.twimg.com/media/Fbrr88FXgAADzHN?format=jpg&name=large");
        showtimeFullViewModel.setGenres(List.of("Comedy","Drama"));
        showtimeFullViewModel.setDescription("A scrappy, feisty, fiercely loyal");
        showtimeFullViewModel.setActors(List.of(actorViewModel));
        showtimeFullViewModel.setEpisodes(List.of(episodeViewModel));

    }

    @Test
    void createShowtime_okay() {
        when(modelMapper.map(cinematicBindingModel, ShowtimeEntity.class)).thenReturn(showtimeEntity);
        when(showtimeRepository.save(showtimeEntity)).thenReturn(showtimeEntity);

        assertEquals(showtimeEntity,showtimeService.createShowtime(cinematicBindingModel));
    }

    @Test
    void getAllApprovedShowtimes_okay() {
        when(showtimeRepository.getShowtimeEntitiesByApprovedTrue()).thenReturn(List.of(showtimeEntity));
        when(modelMapper.map(showtimeEntity,ShowtimeModalViewModel.class)).thenReturn(showtimeModalViewModel);

        assertEquals(List.of(showtimeModalViewModel),showtimeService.getAllApprovedShowtimes());
    }
    @Test
    void getAllApprovedShowtimes_noEpisodes_Okay() {
        showtimeEntity.setEpisodes(new ArrayList<>());
        when(showtimeRepository.getShowtimeEntitiesByApprovedTrue()).thenReturn(List.of(showtimeEntity));
        when(modelMapper.map(showtimeEntity,ShowtimeModalViewModel.class)).thenReturn(showtimeModalViewModel);
        showtimeModalViewModel.setNumberOfEpisodes(0);

        assertEquals(List.of(showtimeModalViewModel),showtimeService.getAllApprovedShowtimes());
    }

    @Test
    void getShowtimeFullViewModelById() {
        when(showtimeRepository.findById("63692ff4f52e5a193d18a43a")).thenReturn(Optional.of(showtimeEntity));
        when(modelMapper.map(showtimeEntity,ShowtimeFullViewModel.class)).thenReturn(showtimeFullViewModel);

        assertEquals(showtimeFullViewModel,showtimeService.getShowtimeFullViewModelById("63692ff4f52e5a193d18a43a"));
    }

    @Test
    void getShowtimeEntityById_throw() {
        when(showtimeRepository.findById("63692ff4f52e5a193d18a43a")).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class,
                () -> showtimeService.getShowtimeEntityById("63692ff4f52e5a193d18a43a"));
    }

}