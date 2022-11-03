package org.example.repository;


import org.example.model.entity.ActorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends MongoRepository<ActorEntity,String> {
}
