package org.example.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Document(collection = "actors")
public class ActorEntity {

    @Id
    private String id;
    private String name;
    private LocalDate birthday;

    public String getId() {
        return id;
    }

    public ActorEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ActorEntity setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public ActorEntity setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }
}
