package com.pg222.fitness.services;

import com.pg222.fitness.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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
                    return user;
                } else {
                    throw new IllegalArgumentException("Incorrect password");
                }
            }
        }
        throw new IllegalArgumentException("User not found");
    }

    public void register(User user) throws IOException {
        List<User> users = fileService.readUsers();

        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                throw new IllegalArgumentException("Username already registered");
            }
            if (existingUser.getEmail().equals(user.getEmail())) {
                throw new IllegalArgumentException("Email already registered");
            }
        }

        fileService.appendUser(user);
    }

    public void updateUser(User updatedUser) throws IOException {
        List<User> users = fileService.readUsers();
        List<User> updatedUsers = new ArrayList<>();

        boolean userFound = false;
        for (User user : users) {
            if (user.getUsername().equals(updatedUser.getUsername())) {
                updatedUsers.add(updatedUser); // Use the updated user with new password/email, same role
                userFound = true;
            } else {
                updatedUsers.add(user);
            }
        }

        if (!userFound) {
            throw new IllegalArgumentException("User not found for update");
        }

        fileService.writeUsers(updatedUsers); // Overwrite file
    }
}