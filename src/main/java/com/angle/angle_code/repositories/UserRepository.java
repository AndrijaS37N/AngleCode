package com.angle.angle_code.repositories;

import com.angle.angle_code.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmailAddress(String emailAddress);
    boolean existsByEmailAddressAndUserPassword(String emailAddress, String userPassword);
}
