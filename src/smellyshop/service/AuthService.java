package smellyshop.service;

import smellyshop.model.User;
import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, User> userDatabase = new HashMap<>();
    private User currentUser;

    public AuthService() {
        userDatabase.put("admin", new User("admin", "admin123", "ADMIN"));
    }

    public void register(String username, String password) {
        if (userDatabase.containsKey(username)) {
            System.out.println("Registration failed: User already exists!");
            return;
        }
        User newUser = new User(username, password, "CUSTOMER");
        userDatabase.put(username, newUser);
        System.out.println("Register success for " + username);
    }

    public boolean login(String username, String password) {
        User user = userDatabase.get(username);
        if (user != null && user.checkPassword(password)) {
            this.currentUser = user;
            System.out.println("Login success! Welcome " + user.getUsername());
            return true;
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public void logout() {
        this.currentUser = null;
        System.out.println("Logged out successfully.");
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
