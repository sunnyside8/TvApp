package org.example.model.binding;


import lombok.Data;

import javax.validation.constraints.*;

public class FilmBindingModel {

    @NotBlank(message = "Please enter a title.")
    private String title;

    @NotBlank(message = "Please enter an img url.")
    private String imgUrl;

    @Min(value = 1900,message = "Please enter year in range 1900-2200.")
    @Max(value = 2200,message = "Please enter year in range 1900-2200.")
    private int yearOfRelease;

    @NotBlank(message = "Please enter one or more genres split by ', ' .")
    private String genres;

    @NotBlank(message = "Please enter one or more actors split by ', ' .")
    private String actors;

    @NotNull(message = "Please enter rating")
    @Positive(message = "The rating must be positive number")
    private double rating;

    @Size(min = 5,message = "Description too short")
    private String description;

    public String getTitle() {
        return title;
    }

    public FilmBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public FilmBindingModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public FilmBindingModel setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
        return this;
    }

    public String getGenres() {
        return genres;
    }

    public FilmBindingModel setGenres(String genres) {
        this.genres = genres;
        return this;
    }

    public String getActors() {
        return actors;
    }

    public FilmBindingModel setActors(String actors) {
        this.actors = actors;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public FilmBindingModel setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FilmBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
