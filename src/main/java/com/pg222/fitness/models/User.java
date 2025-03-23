package com.pg222.fitness.models;

public class User {
    private String username;
    private String password;
    private String email;
    private String role;

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    // Parse from string (username,password,email,role)
    public static User fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            return new User(parts[0], parts[1], parts[2], parts[3]);
        }
        return null;
    }

    // Format to string (username,password,email,role)
    @Override
    public String toString() {
        return username + "," + password + "," + email + "," + role;
    }
}