package org.example.model.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Document(collection = "users")
@Data
public class UserEntity {
    @Id
    private String id;

    @Field(name = "full_name")
    private String fullName;
    private String username;
    private String password;
    private String email;
    private Set<String> roles;




}
