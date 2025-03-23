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
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            User user = userService.login(username, password);
            model.addAttribute("username", user.getUsername());
            return "profile"; // Only on success
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage()); // "Incorrect password" or "User not found"
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "Login failed");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String email, @RequestParam String role, Model model) {
        try {
            userService.register(new User(username, password, email, role));
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage()); // "Username already registered" or "Email already registered"
            return "register";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed");
            return "register";
        }
    }

    @GetMapping("/test")
    public String showTestPage() {
        return "test";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        return "profile";
    }
}