package com.angle.angle_code.services;

import com.angle.angle_code.entities.User;
import com.angle.angle_code.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void autoCreateExtendedUser() {
        long randomSeed = System.currentTimeMillis();
        Random random = new Random();
        random.setSeed(randomSeed);
        User user = new User("autoUser@gmail.com", "a", "a", "a", "a", 20, bCryptPasswordEncoder.encode("a"), true, "ROLE_ADMIN", "ANGLE_ENTITY_ADD");
        userRepository.save(user);
    }

    public void addUser(User user) {
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
        user.setUserRole("ROLE_USER");
        userRepository.save(user);
        user.setConfirmedPassword(null);
        user.setUserPassword(null);
    }

    public boolean checkIfUserExists(User user) {
        return userRepository.existsByEmailAddress(user.getEmailAddress());
    }

    public boolean checkIfPasswordsMatch(String password, String confirmedPassword) {
        return password.equals(confirmedPassword);
    }

    public boolean authenticate(User user) {

        long randomSeed = System.currentTimeMillis();
        Random random = new Random();
        random.setSeed(randomSeed);

        if (userRepository.existsByEmailAddressAndUserPassword(user.getEmailAddress(), user.getUserPassword())) {
            // Note: Let's make the input params for encoding the token these thingies.
            user.setToken(bCryptPasswordEncoder.encode(user.getUserPassword() + user.getAngleUsername() + System.currentTimeMillis() + random.nextGaussian() + random.nextLong()));
            return true;
        }

        return false;
    }
}
