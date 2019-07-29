package com.angle.angle_code.services;

import com.angle.angle_code.repositories.AngleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.angle.angle_code.entities.AngleEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AngleEntityService {

    @Autowired
    private AngleEntityRepository angleEntityRepository;

    public void addAngleEntity(AngleEntity angleEntity) {
        angleEntityRepository.save(angleEntity);
    }

    public void deleteAngleEntity(long id) {
        angleEntityRepository.deleteAngleEntityByAngleEntityId(id);
    }

//    public AngleEntity getAngleEntity(long id) {
//        return angleEntityRepository.getAngleEntityByAngleEntityId(id);
//    }

    public List<AngleEntity> findAllAngleEntities() {
        return angleEntityRepository.findAll();
    }

    public void updateAngleEntity(AngleEntity angleEntity, long id) {

        angleEntity.setAngleEntityId(id);
        angleEntityRepository.save(angleEntity);
    }

    public AngleEntity findAngleEntity(long id) {
        // Note: Function findById is equal to findAngleEntityByAngleEntityId. Use findById for .orElseThrow() addition.
        // return angleEntityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid AE Id:" + id));
        return angleEntityRepository.findAngleEntityByAngleEntityId(id);
    }

    public int findAngleEntitiesCount() {
        return angleEntityRepository.findAll().size();
    }

    public List<AngleEntity> listAngleEntitiesByName(String searchedString) {

        return angleEntityRepository.findAngleEntitiesByAngleEntityNameStartingWith(searchedString);
    }
}
