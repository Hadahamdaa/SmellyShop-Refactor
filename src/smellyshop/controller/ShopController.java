package smellyshop.controller;

import smellyshop.service.AuthService;
import smellyshop.service.ShopService;

public class ShopController {
    // Dependency Injection
    private AuthService authService = new AuthService();
    private ShopService shopService = new ShopService();

    // PERUBAHAN 1: Menangani Output Login
    public void handleLogin(String u, String p) {
        // Controller sekarang mengecek hasil return boolean dari Service
        boolean success = authService.login(u, p);
        
        if (success) {
            // Controller yang bertugas menyapa user (UI Logic)
            String username = authService.getCurrentUser().getUsername();
            System.out.println("Login success! Welcome " + username + " [" + authService.getCurrentUser().getRole() + "]");
        } else {
            // Controller yang memberi tahu jika gagal
            System.out.println("Invalid username or password.");
        }
    }

    // PERUBAHAN 2: Menangani Output Register & Validasi Error
    public void handleRegister(String u, String p) {
        try {
            boolean success = authService.register(u, p);
            
            if (success) {
                System.out.println("Registration success for " + u);
            } else {
                System.out.println("Registration failed: User " + u + " already exists!");
            }
        } catch (IllegalArgumentException e) {
            // Menangkap error validasi (misal username kosong) dari Service
            System.out.println("Error: " + e.getMessage());
        }
    }

    // PERUBAHAN 3: Menangani Output Logout
    public void handleLogout() {
        authService.logout();
        System.out.println("Logged out successfully.");
    }

    // Handle Buy (Tidak banyak berubah, hanya pengecekan login)
    public void handleBuy(String item, int qty) {
        if (!authService.isLoggedIn()) {
            System.out.println("Access Denied: Please login first!");
            return;
        }
        shopService.processPurchase(authService.getCurrentUser(), item, qty);
    }
    
    // Handle History
    public void handleShowHistory() {
        if (!authService.isLoggedIn()) {
             System.out.println("Please login to view history.");
             return;
        }
        shopService.showHistory();
    }
}
