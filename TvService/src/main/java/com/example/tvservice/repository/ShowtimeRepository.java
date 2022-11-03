package com.example.tvservice.repository;

import com.example.tvservice.model.ShowtimeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends MongoRepository<ShowtimeEntity,String> {
}
