package org.example.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorEntity that = (ActorEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}
