package org.example.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "episodes")
@Data
public class EpisodeEntity {
    @Id
    private String id;
    private int season;
    private int episode;
    private String description;
    private boolean approved;
}
