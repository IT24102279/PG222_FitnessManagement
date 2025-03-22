package com.pg222.fitness.services;

import com.pg222.fitness.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private FileService fileService;

    public String registerUser(User user) {
        List<User> users = fileService.readUsers();
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                return "Username already exists!";
            }
        }
        fileService.appendUser(user);
        return "Registration successful!";
    }

    public User login(String username, String password) {
        List<User> users = fileService.readUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User getUserProfile(String username) {
        List<User> users = fileService.readUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public String updateUserProfile(User updatedUser) {
        List<User> users = fileService.readUsers();
        for (User user : users) {
            if (user.getUsername().equals(updatedUser.getUsername())) {
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                fileService.writeUsers(users);
                return "Profile updated successfully!";
            }
        }
        return "User not found!";
    }

    public String deleteUser(String username) {
        List<User> users = fileService.readUsers();
        users.removeIf(user -> user.getUsername().equals(username));
        fileService.writeUsers(users);
        return "User deleted successfully!";
    }
}
