package com.angle.angle_code.services;

import com.angle.angle_code.repositories.AngleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.angle.angle_code.entities.AngleEntity;

@Service
public class AngleEntityService {

    @Autowired
    private AngleEntityRepository angleEntityRepository;

    public void addAngleEntity(AngleEntity angleEntity) {
        angleEntityRepository.save(angleEntity);
    }

    public void printAllAngleEntities() {
        angleEntityRepository.findAll().forEach(x -> System.out.println(x));
    }
}
