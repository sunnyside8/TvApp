package org.example.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
@Document(collection = "actors")
public class ActorEntity {

    @Id
    private String id;
    private String name;
    private LocalDate birthday;
@Field(name = "picture_url")
    private String pictureUrl;

    private boolean approved;

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

    public boolean isApproved() {
        return approved;
    }

    public ActorEntity setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public ActorEntity setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
