package com.angle.angle_code.repositories;

import com.angle.angle_code.entities.AngleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AngleEntityRepository extends CrudRepository<AngleEntity, Long> {

    // Note: Save function is a built-in of CrudRepository, I think.
    List<AngleEntity> findAll();
    List<AngleEntity> findAngleEntityByAngleEntityName(String name);
    void deleteAngleEntityByAngleEntityId(long id);
    // AngleEntity getAngleEntityByAngleEntityId(long id);

    // Note: Use findById for additions like .orElseThrow().
    AngleEntity findAngleEntityByAngleEntityId(long id);
}
