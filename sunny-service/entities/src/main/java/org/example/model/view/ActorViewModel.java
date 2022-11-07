package org.example.model.view;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ActorViewModel {

    private String id;
    private String name;
    private LocalDate birthday;
    private String pictureUrl;


}
