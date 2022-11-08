package org.example.model.edit;


import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class ActorEditModel {

    private String id;
    @NotNull(message = "Please enter date")
    private String birthday;
    @NotNull(message = "Please enter picture url")
    private String pictureUrl;

}
