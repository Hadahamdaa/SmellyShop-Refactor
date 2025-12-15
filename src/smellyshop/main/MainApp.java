package smellyshop.main;

import java.util.Scanner;
import smellyshop.controller.ShopController;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShopController controller = new ShopController();

        boolean running = true;
        System.out.println("=== Welcome to Refactored SmellyShop ===");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Buy Item");
            System.out.println("4. History");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); 
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Username: ");
                    String u = scanner.nextLine();
                    System.out.print("Password: ");
                    String p = scanner.nextLine();
                    controller.handleLogin(u, p);
                    break;
                case 2:
                    System.out.print("Username: ");
                    String regU = scanner.nextLine();
                    System.out.print("Password: ");
                    String regP = scanner.nextLine();
                    controller.handleRegister(regU, regP);
                    break;
                case 3:
                    System.out.print("Item (BOOK/PEN/LAPTOP): ");
                    String item = scanner.nextLine();
                    System.out.print("Qty: ");
                    if (scanner.hasNextInt()) {
                        int q = scanner.nextInt();
                        scanner.nextLine();
                        controller.handleBuy(item, q);
                    } else {
                        System.out.println("Invalid quantity!");
                        scanner.next();
                    }
                    break;
                case 4:
                    controller.handleShowHistory();
                    break;
                case 5:
                    controller.handleLogout();
                    break;
                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
        scanner.close();
    }
}
