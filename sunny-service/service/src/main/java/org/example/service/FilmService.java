package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.binding.FilmBindingModel;
import org.example.model.entity.FilmEntity;
import org.example.repository.FilmRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    public String createFilm(FilmBindingModel film) {
        return "";
    }
}
