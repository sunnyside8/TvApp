package org.example.model.entity;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "films")
@Builder
public class FilmEntity extends CinematicEntity{

}
