package com.angle.angle_code.repositories;

import com.angle.angle_code.entities.AngleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AngleEntityRepository extends CrudRepository<AngleEntity, Long> {

    List<AngleEntity> findAll();
    List<AngleEntity> findAngleEntityByAngleEntityName(String name);
    void deleteAngleEntityByAngleEntityId(long id);
    AngleEntity getAngleEntityByAngleEntityId(long id);
}
