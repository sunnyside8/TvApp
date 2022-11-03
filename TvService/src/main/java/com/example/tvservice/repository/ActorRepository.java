package com.example.tvservice.repository;

import com.example.tvservice.model.ActorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends MongoRepository<ActorEntity,String> {
}
