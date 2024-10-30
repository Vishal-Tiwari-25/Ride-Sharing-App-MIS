package com.ridesharing.rideshare.service;

import com.ridesharing.rideshare.model.User;
import com.ridesharing.rideshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to create a user
    public User createUser(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        return userRepository.save(user);
    }

    // Method to retrieve a user by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Method to retrieve a user by ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
