package org.example.model.binding;


import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CinematicBindingModel {

    @NotBlank(message = "Please select type.")
    private String type;

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

    @Size(min = 30,message = "Description too short.Minimum 30 symbols.")
    private String description;
}