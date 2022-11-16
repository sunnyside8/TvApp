package org.example.repository;


import org.example.model.entity.ActorEntity;
import org.example.model.view.ActorView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends MongoRepository<ActorEntity,String> {

    Optional<ActorEntity> findActorEntityByName(String name);

    List<ActorEntity> findActorEntitiesByApprovedTrue();

    ActorView findByName(String name);
}
