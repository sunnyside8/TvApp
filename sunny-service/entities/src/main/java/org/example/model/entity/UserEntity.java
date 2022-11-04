package org.example.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "")
@Data
public class UserEntity {
    @Id
    private String id;

    private String username;

    private String password;

    private String email;




}
