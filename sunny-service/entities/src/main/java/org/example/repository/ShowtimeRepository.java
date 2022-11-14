package org.example.repository;


import org.example.model.entity.ShowtimeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends MongoRepository<ShowtimeEntity,String> {

    List<ShowtimeEntity> getShowtimeEntitiesByApprovedTrue();
}
