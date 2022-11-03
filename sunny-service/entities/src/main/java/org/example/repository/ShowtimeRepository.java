package org.example.repository;


import org.example.model.entity.ShowtimeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends MongoRepository<ShowtimeEntity,String> {
}
