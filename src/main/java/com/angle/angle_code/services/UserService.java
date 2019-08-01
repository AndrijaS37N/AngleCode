package com.angle.angle_code.services;

import com.angle.angle_code.entities.User;
import com.angle.angle_code.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Note: Registration, adding. Place logic here before the actual 'save'.
    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean checkIfUserExists(User user) {
        return userRepository.existsByEmailAddress(user.getEmailAddress());
    }

    public boolean checkIfPasswordsMatch(String password, String confirmedPassword) {
        return password.equals(confirmedPassword);
    }
}
