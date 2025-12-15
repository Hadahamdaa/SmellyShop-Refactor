package smellyshop.model;

public enum Product {
    
    BOOK(100),
    PEN(10),
    LAPTOP(1000),
    
    
    MOUSE(50),
    KEYBOARD(150),
    GAMING_CHAIR(2500),
    GAMING_TABLE(1800),
    WEBCAM(450),
    HEADSET(300),
    
    
    OTHER(50);

    private final int price;

    Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}