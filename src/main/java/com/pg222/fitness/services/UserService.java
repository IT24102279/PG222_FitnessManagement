package com.pg222.fitness.services;

import com.pg222.fitness.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private FileService fileService;

    public User login(String username, String password) throws IOException {
        List<User> users = fileService.readUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return user; // Return full User object
                } else {
                    throw new IllegalArgumentException("Incorrect password");
                }
            }
        }
        throw new IllegalArgumentException("User not found");
    }

    public void register(User user) throws IOException {
        List<User> users = fileService.readUsers();

        // Check for duplicates
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                throw new IllegalArgumentException("Username already registered");
            }
            if (existingUser.getEmail().equals(user.getEmail())) {
                throw new IllegalArgumentException("Email already registered");
            }
        }

        // Register new user
        fileService.appendUser(user);
    }
}