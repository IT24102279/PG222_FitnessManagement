package com.pg222.fitness.controllers;

import com.pg222.fitness.models.User;
import com.pg222.fitness.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @GetMapping("/{username}")
    public User getUserProfile(@PathVariable String username) {
        return userService.getUserProfile(username);
    }

    @PutMapping("/update")
    public String updateUserProfile(@RequestBody User user) {
        return userService.updateUserProfile(user);
    }

    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable String username) {
        return userService.deleteUser(username);
    }
}
