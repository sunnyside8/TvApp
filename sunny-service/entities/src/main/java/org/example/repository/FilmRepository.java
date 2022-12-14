package org.example.repository;


import org.example.model.entity.FilmEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends MongoRepository<FilmEntity,String> {

    List<FilmEntity> getFilmEntitiesByApprovedTrue();
}
