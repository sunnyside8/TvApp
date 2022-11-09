package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.binding.CinematicBindingModel;
import org.example.model.entity.ActorEntity;
import org.example.model.entity.FilmEntity;
import org.example.model.enums.GenreEnum;
import org.example.model.view.FilmModalViewModel;
import org.example.repository.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;
    private final ModelMapper modelMapper;
    private final ActorService actorService;

    public FilmEntity createFilm(CinematicBindingModel film) {
        List<GenreEnum> genres = Arrays.stream(film.getGenres().split(", "))
                .map(line -> GenreEnum.valueOf(line)).toList();

        List<ActorEntity> actors =  actorService.findActorsOrCreateAndReturnAsList(film.getActors());

        FilmEntity filmEntity = modelMapper.map(film,FilmEntity.class);
        filmEntity.setActors(actors);
        filmEntity.setGenres(genres);

        return filmRepository.save(filmEntity);
    }

    public List<FilmModalViewModel> getAllApprovedFilms() {
        return filmRepository.getFilmEntitiesByApprovedTrue()
                .stream().map(film -> {
                    FilmModalViewModel filmModalViewModel = modelMapper.map(film, FilmModalViewModel.class);
                    try {
                        filmModalViewModel.setOneOfTheGenres(film.getGenres().get(0).name());
                    }catch (Exception e){
                        //logg that there is a movie with no genres => admin mistake or substring error
                    }
                    filmModalViewModel.setDescription(film.getDescription().substring(0,33));
                    return filmModalViewModel;
                })
                .collect(Collectors.toList());
    }
}
