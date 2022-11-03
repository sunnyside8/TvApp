package com.example.tvservice.repository;

import com.example.tvservice.model.FilmEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends MongoRepository<FilmEntity,String> {
}
