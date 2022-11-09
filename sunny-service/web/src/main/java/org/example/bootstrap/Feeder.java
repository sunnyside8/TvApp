package org.example.bootstrap;

import lombok.AllArgsConstructor;
import org.example.model.entity.ActorEntity;
import org.example.model.entity.FilmEntity;
import org.example.model.enums.GenreEnum;
import org.example.repository.ActorRepository;
import org.example.repository.EpisodeRepository;
import org.example.repository.FilmRepository;
import org.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class Feeder implements CommandLineRunner {
    private final FilmRepository filmRepository;
    private final ActorRepository actorRepository;
    private final UserRepository userRepository;
    private final EpisodeRepository episodeRepository;


    @Override
    public void run(String... args) throws Exception {
        if(actorRepository.count() ==0 ){
            ActorEntity actorEntity = new ActorEntity();
            actorEntity.setId("636b678206199f11c7dc2494");
            actorEntity.setName("Dwayne Johnson");
            actorEntity.setBirthday(LocalDate.of(1972,5,2));
            actorEntity.setPictureUrl("https://cdn.britannica.com/60/222660-050-064DBA89/Dwayne-Johnson-AKA-The-Rock-2019.jpg");

            ActorEntity actorEntity1 = new ActorEntity();
            actorEntity1.setId("636b678206199f11c7dc2495");
            actorEntity1.setName("Aldis Hodge");
            actorEntity1.setBirthday(LocalDate.of(1986,9,20));
            actorEntity1.setPictureUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Aldis_Hodge_2016.jpg/800px-Aldis_Hodge_2016.jpg");

            ActorEntity actorEntity2 = new ActorEntity();
            actorEntity2.setId("636b678206199f11c7dc2496");
            actorEntity2.setName("Pierce Brosnan");
            actorEntity2.setBirthday(LocalDate.of(1953,5,16));
            actorEntity2.setPictureUrl("https://www.indiewire.com/wp-content/uploads/2022/10/Pierce-Brosnan.png");

            actorRepository.saveAll(List.of(actorEntity,actorEntity1,actorEntity2));
        }

        if(filmRepository.count() == 0){
            FilmEntity filmEntity = new FilmEntity();
            filmEntity.setTitle("Black Adam");
            filmEntity.setYearOfRelease(2022);
            filmEntity.setGenres(List.of(GenreEnum.Action,GenreEnum.Adventure));
            filmEntity.setActors(List.of(
                    actorRepository.findById("636b678206199f11c7dc2494").get(),
                    actorRepository.findById("636b678206199f11c7dc2495").get(),
                    actorRepository.findById("636b678206199f11c7dc2496").get()
                    ));
            filmEntity.setDescription("Nearly 5,000 years after he was bestowed with the almighty powers of the ancient" +
                    " gods--and imprisoned just as quickly--Black Adam (Dwayne Johnson) is freed from his earthly tomb," +
                    " ready to unleash his unique form of justice on the modern world.");
            filmEntity.setRating(8.00);
            filmEntity.setImgUrl("https://pbs.twimg.com/media/Fbrr88FXgAADzHN?format=jpg&name=large");
            filmEntity.setApproved(true);

            filmRepository.save(filmEntity);
        }
    }
}
