package com.example.tvservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "films")
public class FilmEntity extends CinematicEntity{

}
