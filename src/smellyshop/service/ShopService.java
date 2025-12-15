package smellyshop.service;

import smellyshop.model.Product;
import smellyshop.model.User;
import java.util.ArrayList;
import java.util.List;

public class ShopService {
    private List<String> transactionHistory = new ArrayList<>();

    public void processPurchase(User user, String productName, int qty) {
        try {
            Product product = Product.valueOf(productName.toUpperCase());
            int total = calculateTotal(user, product, qty);
            
            String record = String.format("User %s bought %d %s. Total: %d", 
                            user.getUsername(), qty, product, total);
            
            transactionHistory.add(record);
            System.out.println("Transaction Success: " + record);

        } catch (IllegalArgumentException e) {
            System.out.println("Item not found! Available items: BOOK, PEN, LAPTOP.");
        }
    }

    private int calculateTotal(User user, Product product, int qty) {
        int total = product.getPrice() * qty;

        if (qty > 10) {
            total -= 20;
        }
        
        if ("ADMIN".equalsIgnoreCase(user.getRole()) || "admin".equalsIgnoreCase(user.getUsername())) {
            total = 0;
        }
        
        return total;
    }
    
    public void showHistory() {
        System.out.println("\n--- Transaction History ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String record : transactionHistory) {
                System.out.println(record);
            }
        }
    }
}
