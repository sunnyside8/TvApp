package com.example.tvservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public abstract class CinematicEntity {

    @Id
    private String id;
    private String title;

    private int yearOfRelease;
    private List<GenreEntity> genres;
    private List<ActorEntity> actors;
    private double rating;
   private  String description;
    boolean approved;
}
