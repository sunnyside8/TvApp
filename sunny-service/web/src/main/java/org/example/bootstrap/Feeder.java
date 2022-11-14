package org.example.bootstrap;

import lombok.AllArgsConstructor;
import org.example.model.entity.ActorEntity;
import org.example.model.entity.FilmEntity;
import org.example.model.entity.ShowtimeEntity;
import org.example.model.entity.UserEntity;
import org.example.model.enums.GenreEnum;
import org.example.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class Feeder implements CommandLineRunner {
    private final FilmRepository filmRepository;
    private final ActorRepository actorRepository;
    private final UserRepository userRepository;
    private final ShowtimeRepository showtimeRepository;
    private final EpisodeRepository episodeRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        if(actorRepository.count() ==0 ){
            ActorEntity actorEntity = new ActorEntity();
            actorEntity.setId("636b678206199f11c7dc2494");
            actorEntity.setName("Dwayne Johnson");
            actorEntity.setBirthday(LocalDate.of(1972,5,2));
            actorEntity.setPictureUrl("https://cdn.britannica.com/60/222660-050-064DBA89/Dwayne-Johnson-AKA-The-Rock-2019.jpg");
            actorEntity.setApproved(true);

            ActorEntity actorEntity1 = new ActorEntity();
            actorEntity1.setId("636b678206199f11c7dc2495");
            actorEntity1.setName("Aldis Hodge");
            actorEntity1.setBirthday(LocalDate.of(1986,9,20));
            actorEntity1.setPictureUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Aldis_Hodge_2016.jpg/800px-Aldis_Hodge_2016.jpg");
            actorEntity1.setApproved(true);

            ActorEntity actorEntity2 = new ActorEntity();
            actorEntity2.setId("636b678206199f11c7dc2496");
            actorEntity2.setName("Pierce Brosnan");
            actorEntity2.setBirthday(LocalDate.of(1953,5,16));
            actorEntity2.setPictureUrl("https://www.indiewire.com/wp-content/uploads/2022/10/Pierce-Brosnan.png");
            actorEntity2.setApproved(true);

            ActorEntity actorEntity3 = new ActorEntity();
            actorEntity3.setId("63692ff4f52e5a193d18a437");
            actorEntity3.setName("Emmy Rossum");
            actorEntity3.setBirthday(LocalDate.of(1986,9,16));
            actorEntity3.setPictureUrl("https://media.glamour.com/photos/59ff8c15b0ba91733b05cfad/6:7/w_2831,h_3303,c_limit/emmy-rossum-burts-bees.JPG");
            actorEntity3.setApproved(true);

            ActorEntity actorEntity4 = new ActorEntity();
            actorEntity4.setId("63692ff4f52e5a193d18a438");
            actorEntity4.setName("William H. Macy");
            actorEntity4.setBirthday(LocalDate.of(1950,3,13));
            actorEntity4.setPictureUrl("https://m.media-amazon.com/images/M/MV5BMjIzOTk5MTAzNV5BMl5BanBnXkFtZTcwNTk0MzMyNw@@._V1_.jpg");
            actorEntity4.setApproved(true);

            actorRepository.saveAll(List.of(actorEntity,actorEntity1,actorEntity2,actorEntity3,actorEntity4));
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

        if(userRepository.count() == 0){
            UserEntity adminEntity = new UserEntity();
            adminEntity.setUsername("admin");
            adminEntity.setEmail("admin@abv.bg");
            adminEntity.setPassword(passwordEncoder.encode("12345"));
            adminEntity.setRoles(Set.of("USER","ADMIN"));
            adminEntity.setFullName("Admi Admivich");


            UserEntity userEntity = new UserEntity();
            userEntity.setUsername("user");
            userEntity.setEmail("user@abv.bg");
            userEntity.setPassword(passwordEncoder.encode("12345"));
            userEntity.setRoles(Set.of("USER"));
            userEntity.setFullName("Usre Usuing");

            userRepository.saveAll(List.of(userEntity,adminEntity));
        }

        if(showtimeRepository.count() == 0){
            ShowtimeEntity showtimeEntity = new ShowtimeEntity();
            showtimeEntity.setId("63692ff4f52e5a193d18a43a");
            showtimeEntity.setTitle("Shameless");
            showtimeEntity.setImgUrl("https://m.media-amazon.com/images/I/71oDvfRzxtL._AC_SL1000_.jpg");
            showtimeEntity.setYearOfRelease(2011);
            showtimeEntity.setGenres(List.of(GenreEnum.Comedy,GenreEnum.Drama));
            showtimeEntity.setActors(
                    List.of(
                            actorRepository.findById("63692ff4f52e5a193d18a437").get(),
                            actorRepository.findById("63692ff4f52e5a193d18a438").get()
                    )
            );
            showtimeEntity.setRating(9);
            showtimeEntity.setDescription("A scrappy, feisty, fiercely loyal Chicago family makes no apologies.");
            showtimeEntity.setApproved(true);

           showtimeRepository.save(showtimeEntity);
        }

    }
}
