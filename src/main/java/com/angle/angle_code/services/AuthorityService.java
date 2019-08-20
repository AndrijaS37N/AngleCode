package com.angle.angle_code.services;

import com.angle.angle_code.entities.Authority;
import com.angle.angle_code.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;

    public void autoCreateAuthorities() {
        Authority angleEntityAddition = new Authority("ANGLE_ENTITY_ADD");
        authorityRepository.save(angleEntityAddition);
    }
}