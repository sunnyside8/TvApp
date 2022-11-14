package org.example.service;

import org.example.model.binding.CinematicBindingModel;
import org.example.model.entity.ActorEntity;
import org.example.model.entity.ShowtimeEntity;
import org.example.model.enums.GenreEnum;
import org.example.model.view.ActorViewModel;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

        showtimeModalViewModel.setId("63692ff4f52e5a193d18a43a");
        showtimeModalViewModel.setTitle("Serialche");
        showtimeModalViewModel.setImgUrl("https://pbs.twimg.com/media/Fbrr88FXgAADzHN?format=jpg&name=large");
        showtimeModalViewModel.setOneOfTheGenres("Comdey");
        showtimeModalViewModel.setDescription("A scrappy, feisty, fiercely loyal");
    }

//    @Test
//    void createShowtime() {
//    }
//
//    @Test
//    void getAllApprovedShowtimes() {
//    }
//
//    @Test
//    void getShowtimeFullViewModelById() {
//    }
//
//    @Test
//    void getShowtimeEntityById() {
//    }
}