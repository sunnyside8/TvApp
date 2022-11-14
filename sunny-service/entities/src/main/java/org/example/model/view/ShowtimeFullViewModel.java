package org.example.model.view;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ShowtimeFullViewModel {

    private String id;
    private String title;
    private String imgUrl;
    private int yearOfRelease;
    private List<String> genres;
    private List<ActorViewModel> actors  = new ArrayList<>();
    private List<EpisodeViewModel> episodes = new ArrayList<>();
    private double rating;
    private String description;

}
