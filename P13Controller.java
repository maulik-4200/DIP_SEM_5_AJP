package com.example.p13;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class P13Controller {

    // In-memory list to store registered users
    private List<User> users = new ArrayList<>();

    // Show the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "P13-login";
    }

    // Handle login request
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                model.addAttribute("username", username);
                return "P13-welcome";
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "P13-login";
    }

    // Show the registration page
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "P13-register";
    }

    // Handle registration request
    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model) {
        users.add(new User(username, password));
        model.addAttribute("message", "User registered successfully");
        return "P13-login";
    }

    // Simple User class to store user details
    static class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
