package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.binding.CinematicBindingModel;
import org.example.model.entity.ActorEntity;
import org.example.model.entity.ShowtimeEntity;
import org.example.model.enums.GenreEnum;
import org.example.repository.ShowtimeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final ActorService actorService;
    private final ModelMapper modelMapper;


    public ShowtimeEntity createShowtime(CinematicBindingModel showtime) {
        List<GenreEnum> genres = Arrays.stream(showtime.getGenres().split(", "))
                .map(GenreEnum::valueOf).toList();

        List<ActorEntity> actors =  actorService.findActorsOrCreateAndReturnAsList(showtime.getActors());

        ShowtimeEntity showtimeEntity = modelMapper.map(showtime, ShowtimeEntity.class);
        showtimeEntity.setActors(actors);
        showtimeEntity.setGenres(genres);

        return showtimeRepository.save(showtimeEntity);
    }
}
