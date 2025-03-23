package com.pg222.fitness.controllers;

import com.pg222.fitness.models.User;
import com.pg222.fitness.services.UserService;
import jakarta.servlet.http.HttpSession;
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
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        try {
            User user = userService.login(username, password);
            session.setAttribute("loggedInUser", user); // Store user in session
            model.addAttribute("username", user.getUsername());
            return "profile";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
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
            model.addAttribute("error", e.getMessage());
            return "register";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed");
            return "register";
        }
    }

    @GetMapping("/profile")
    public String showProfile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login"; // Redirect if not logged in
        }
        model.addAttribute("username", user.getUsername());
        return "profile";
    }

    @GetMapping("/update")
    public String showUpdateForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user); // Pass current user details to form
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam String password, @RequestParam String email,
                             Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        try {
            // Create updated User with original username and role
            User updatedUser = new User(user.getUsername(), password, email, user.getRole());
            userService.updateUser(updatedUser);
            session.setAttribute("loggedInUser", updatedUser); // Update session
            model.addAttribute("username", updatedUser.getUsername());
            return "profile";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("user", user);
            return "update";
        } catch (Exception e) {
            model.addAttribute("error", "Update failed");
            model.addAttribute("user", user);
            return "update";
        }
    }
}