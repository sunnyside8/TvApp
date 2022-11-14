package org.example.model.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "showtime")
@Data
public class ShowtimeEntity extends CinematicEntity{


    private List<EpisodeEntity> episodes = new ArrayList<>();


}
