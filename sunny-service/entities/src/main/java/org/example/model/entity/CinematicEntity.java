package org.example.model.entity;

import org.example.model.enums.GenreEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public abstract class CinematicEntity {

    @Id
    private String id;

    private String title;
    @Field(name = "img_url")
    private String imgUrl;

    @Field(name = "year_of_release")
    private int yearOfRelease;

    private List<GenreEnum> genres;

    @DBRef
    private List<ActorEntity> actors;

    private double rating;

    private String description;

    private boolean approved;

    public String getId() {
        return id;
    }

    public CinematicEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CinematicEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public CinematicEntity setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public CinematicEntity setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
        return this;
    }

    public List<GenreEnum> getGenres() {
        return genres;
    }

    public CinematicEntity setGenres(List<GenreEnum> genres) {
        this.genres = genres;
        return this;
    }

    public List<ActorEntity> getActors() {
        return actors;
    }

    public CinematicEntity setActors(List<ActorEntity> actors) {
        this.actors = actors;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public CinematicEntity setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CinematicEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isApproved() {
        return approved;
    }

    public CinematicEntity setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }
}
