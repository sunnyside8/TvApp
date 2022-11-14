package org.example.model.view;

import lombok.Data;

@Data
public class ShowtimeModalViewModel {

    private String id;
    private String title;
    private String imgUrl;
    private int yearOfRelease;
    private String oneOfTheGenres;
    private String description;
    private int numberOfEpisodes;
}
