package org.example.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Data
public abstract class CinematicEntity {

    @Id
    private String id;

    private String title;

    private String imgUrl;

    @Field(name = "year_of_release")
    private int yearOfRelease;

    private List<GenreEntity> genres;

    @DBRef
    private List<ActorEntity> actors;

    private double rating;

    private String description;

    private boolean approved;
}
