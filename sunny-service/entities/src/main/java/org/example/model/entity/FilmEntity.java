package org.example.model.entity;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "films")
public class FilmEntity extends CinematicEntity{

}
