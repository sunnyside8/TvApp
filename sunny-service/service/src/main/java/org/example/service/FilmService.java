package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.binding.CinematicBindingModel;
import org.example.model.entity.ActorEntity;
import org.example.model.entity.FilmEntity;
import org.example.model.entity.GenreEntity;
import org.example.model.enums.GenreEnum;
import org.example.repository.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;
    private final ModelMapper modelMapper;
    private final ActorService actorService;

    public FilmEntity createFilm(CinematicBindingModel film) {
        List<GenreEntity> genres = Arrays.stream(film.getGenres().split(", "))
                .map(line -> new GenreEntity(GenreEnum.valueOf(line))).toList();

        List<ActorEntity> actors =  actorService.findActorsOrCreateAndReturnAsList(film.getActors());

        FilmEntity filmEntity = modelMapper.map(film,FilmEntity.class);
        filmEntity.setActors(actors);
        filmEntity.setGenres(genres);

        return filmRepository.save(filmEntity);
    }
}
