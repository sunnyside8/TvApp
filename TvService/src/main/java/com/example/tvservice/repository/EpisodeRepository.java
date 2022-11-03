package com.example.tvservice.repository;

import com.example.tvservice.model.EpisodeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends MongoRepository<EpisodeEntity,String> {

}
