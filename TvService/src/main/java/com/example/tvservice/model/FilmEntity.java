package com.example.tvservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "films")
@Builder
public class FilmEntity extends CinematicEntity{

}
