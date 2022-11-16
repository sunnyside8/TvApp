package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.binding.CinematicBindingModel;
import org.example.model.binding.EpisodeBindingModel;
import org.example.model.entity.ActorEntity;
import org.example.model.entity.EpisodeEntity;
import org.example.model.entity.FilmEntity;
import org.example.model.entity.ShowtimeEntity;
import org.example.model.enums.GenreEnum;
import org.example.model.view.ActorViewModel;
import org.example.model.view.EpisodeViewModel;
import org.example.model.view.ShowtimeFullViewModel;
import org.example.model.view.ShowtimeModalViewModel;
import org.example.repository.ShowtimeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ShowtimeModalViewModel> getAllApprovedShowtimes() {
        return showtimeRepository.getShowtimeEntitiesByApprovedTrue().stream()
                .map(showtime -> {
                    ShowtimeModalViewModel showtimeMVM = modelMapper.map(showtime,ShowtimeModalViewModel.class);
                    try{
                        showtimeMVM.setOneOfTheGenres(showtime.getGenres().get(0).name());
                    } catch (Exception e){
                        ///log mistake
                    }
                    showtimeMVM.setDescription(showtime.getDescription().substring(0,33));
                    showtimeMVM.setNumberOfEpisodes(showtime.getEpisodes().size() == 0
                            ? 0
                            : showtime.getEpisodes().size());
                    return showtimeMVM;
                })
                .collect(Collectors.toList());
    }

    public ShowtimeFullViewModel getShowtimeFullViewModelById(String id) {
        ShowtimeEntity showtimeEntity = getShowtimeEntityById(id);
        ShowtimeFullViewModel showtimeFullViewModel = modelMapper.map(showtimeEntity,ShowtimeFullViewModel.class);
        showtimeFullViewModel.setActors(showtimeEntity.getActors().stream()
                .map(actor -> modelMapper.map(actor, ActorViewModel.class))
                .collect(Collectors.toList()));
        showtimeFullViewModel.setEpisodes(showtimeEntity.getEpisodes().stream()
                .map(episode -> modelMapper.map(episode, EpisodeViewModel.class))
                .collect(Collectors.toList()));
        return showtimeFullViewModel;
    }

    public ShowtimeEntity getShowtimeEntityById(String id){
        return showtimeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No showtime with this id found"));
    }

    @Transactional
    public ShowtimeEntity createEpisodeForShowtimeWithId(String id, EpisodeBindingModel episodeBindingModel) {
        EpisodeEntity episodeEntity = modelMapper.map(episodeBindingModel,EpisodeEntity.class);

        episodeEntity.setId("s" + episodeEntity.getSeason() + "e" + episodeEntity.getEpisode());

        ShowtimeEntity showtimeEntity = getShowtimeEntityById(id);
        showtimeEntity.getEpisodes().add(episodeEntity);

        return showtimeRepository.save(showtimeEntity);
    }
}
