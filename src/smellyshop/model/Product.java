package smellyshop.model;

public enum Product {
    BOOK(100),
    PEN(10),
    LAPTOP(1000),
    OTHER(50);

    private final int price;

    Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
