package org.example.model.view;

import lombok.Data;

import java.util.List;
@Data
public class FilmFullViewModel {

    private String id;
    private String title;
    private String imgUrl;
    private int yearOfRelease;
    private List<String> genres;
    private List<ActorViewModel> actors;
    private double rating;
    private String description;

}
