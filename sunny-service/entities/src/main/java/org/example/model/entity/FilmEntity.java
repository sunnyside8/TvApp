package org.example.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "films")
public class FilmEntity extends CinematicEntity{

}
