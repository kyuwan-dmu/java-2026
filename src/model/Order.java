package model;

public class Order {

    private String orderId;
    private String productName;
    private String option;
    private int quantity;
    private String brand;
    private int price;
    private String orderDate;
    private String status;
    private String region;

    public Order(String orderId, String productName, String option, int quantity,
                 String brand, int price, String orderDate, String status, String region) {
        this.orderId = orderId;
        this.productName = productName;
        this.option = option;
        this.quantity = quantity;
        this.brand = brand;
        this.price = price;
        this.orderDate = orderDate;
        this.status = status;
        this.region = region;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public String getOption() {
        return option;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "[" + brand + "] " + productName + " - " + String.format("%,d", price) + "원";
    }
}
