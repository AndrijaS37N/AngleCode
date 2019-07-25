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

    public AngleEntity getAngleEntity(long id) {
        return angleEntityRepository.getAngleEntityByAngleEntityId(id);
    }

//    public void printAllAngleEntities() {
//        angleEntityRepository.findAll().forEach(x -> System.out.println(x));
//    }

    public List<AngleEntity> findAllAngleEntities() {
        return angleEntityRepository.findAll();
    }
}
