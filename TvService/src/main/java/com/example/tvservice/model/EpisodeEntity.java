package com.example.tvservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "episodes")
@Data
public class EpisodeEntity {

    private String id;
    private int season;
    private int episode;
    private String description;
    private boolean approved;
}
