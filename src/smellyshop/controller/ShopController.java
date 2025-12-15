package smellyshop.controller;

import smellyshop.service.AuthService;
import smellyshop.service.ShopService;

public class ShopController {
    private AuthService authService = new AuthService();
    private ShopService shopService = new ShopService();

    public void handleLogin(String u, String p) {
        authService.login(u, p);
    }

    public void handleRegister(String u, String p) {
        authService.register(u, p);
    }

    public void handleLogout() {
        authService.logout();
    }

    public void handleBuy(String item, int qty) {
        if (!authService.isLoggedIn()) {
            System.out.println("Access Denied: Please login first!");
            return;
        }
        shopService.processPurchase(authService.getCurrentUser(), item, qty);
    }
    
    public void handleShowHistory() {
        if (!authService.isLoggedIn()) {
             System.out.println("Please login to view history.");
             return;
        }
        shopService.showHistory();
    }
}
