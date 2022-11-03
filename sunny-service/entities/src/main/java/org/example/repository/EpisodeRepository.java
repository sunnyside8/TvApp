package org.example.repository;


import org.example.model.entity.EpisodeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends MongoRepository<EpisodeEntity,String> {

}
