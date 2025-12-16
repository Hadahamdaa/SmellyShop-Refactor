package smellyshop.service;

import smellyshop.model.User;
import java.util.HashMap;
import java.util.Map;

public class AuthService {
    // Database simulasi (In-Memory)
    private Map<String, User> userDatabase = new HashMap<>();
    private User currentUser;

    public AuthService() {
        // Data Seeding: Idealnya ini di-load dari file config atau database eksternal
        // Tapi untuk simulasi, kita rapikan sedikit.
        initializeDefaultUsers();
    }

    private void initializeDefaultUsers() {
        // Menggunakan method helper agar Constructor tetap bersih
        User admin = new User("admin", "admin123", "ADMIN");
        userDatabase.put(admin.getUsername(), admin);
    }

    // REFACTOR: Mengubah void menjadi boolean/User agar UI (Controller) yang print, bukan Service
    public boolean register(String username, String password) {
        if (username == null || password == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty.");
        }

        if (userDatabase.containsKey(username)) {
            return false; // Gagal: User sudah ada
        }

        // Default role is CUSTOMER
        User newUser = new User(username, password, "CUSTOMER");
        userDatabase.put(username, newUser);
        return true; // Berhasil
    }

    // REFACTOR: Return boolean/User object, jangan println di sini
    public boolean login(String username, String password) {
        if (username == null || password == null) return false;

        User user = userDatabase.get(username);
        
        // Delegasi pengecekan password ke object User (Encapsulation)
        if (user != null && user.checkPassword(password)) {
            this.currentUser = user;
            return true;
        }
        return false;
    }

    public void logout() {
        this.currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
