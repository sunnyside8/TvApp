package org.example.model.edit;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class ActorEditModel {

    private String id;
    @NotBlank(message = "Please enter date")
    private String birthday;
    @NotBlank(message = "Please enter picture url")
    private String pictureUrl;

}
