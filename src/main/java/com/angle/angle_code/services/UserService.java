package com.angle.angle_code.services;

import com.angle.angle_code.entities.User;
import com.angle.angle_code.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addUser(User user) {
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
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

        // TODO -> For logging in.

        return false;
    }
}
