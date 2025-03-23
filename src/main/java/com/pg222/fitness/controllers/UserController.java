package com.pg222.fitness.controllers;

import com.pg222.fitness.models.User;
import com.pg222.fitness.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Maps to login.jsp
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            User user = userService.login(username, password);
            // On success, redirect to a profile page or dashboard
            return "redirect:/profile";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // Maps to register.jsp
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String role,
            Model model) {
        try {
            userService.registerUser(new User(username, password, email, role));
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed");
            return "register";
        }
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        // Add profile logic if needed
        return "profile"; // Create profile.jsp later if desired
    }
}