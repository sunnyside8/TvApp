package org.example.model.binding;


import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Data
public class CinematicBindingModel {

    @NotBlank(message = "Please select type.")
    private String type;

    @NotBlank(message = "Please enter a title.")
    @Size(min = 1,max = 60,message = "Title must be between 1 and 60 symbols.")
    private String title;

    @NotBlank(message = "Please enter an img url.")
    private String imgUrl;

    @Range(min = 1900,max = 2200,message = "Please enter year in range 1900-2200.")
    private int yearOfRelease;

    @NotBlank(message = "Please enter one or more genres split by ', '")
    private String genres;

    @NotBlank(message = "Please enter one or more actors split by ', '")
    private String actors;

    @NotNull(message = "Please enter rating")
    @Positive(message = "The rating must be positive number")
    private double rating;

    @Size(min = 30,message = "Description too short.Minimum 30 symbols.")
    private String description;
}
