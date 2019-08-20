package com.angle.angle_code.services;

import com.angle.angle_code.entities.Role;
import com.angle.angle_code.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public void autoCreateRoles() {
        Role user = new Role("ROLE_USER", "Bla bla bla.");
        Role admin = new Role("ROLE_ADMIN", "Bla bla bla, bla bla.");
        roleRepository.save(user);
        roleRepository.save(admin);
    }
}