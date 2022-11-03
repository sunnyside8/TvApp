package com.example.tvservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Document(collection = "actors")
@Data
@Builder
public class ActorEntity {

    @Id
    private String id;
    private String name;
    private LocalDate birthday;

}
