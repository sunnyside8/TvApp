package com.example.tvservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public abstract class CinematicEntity {

    @Id
    private String id;

    private String title;

    @Field(name = "year_of_release")
    private int yearOfRelease;

    private List<GenreEntity> genres;

    @DBRef
    private List<ActorEntity> actors;

    private double rating;

    private String description;

    private boolean approved;
}
