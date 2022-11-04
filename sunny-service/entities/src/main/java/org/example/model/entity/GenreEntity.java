package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.model.enums.GenreEnum;

@Data
@AllArgsConstructor
public class GenreEntity {

    private GenreEnum genre;
}
