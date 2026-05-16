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
        this.option = option.isEmpty() ? "(없음)" : option;
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

    public void printOrderInfo() {
        System.out.printf("%s %s - %d 원\n",
                this.getBrand(), this.getProductName(), this.getPrice());
    }

    public void printOrderInfoDetails() {
        System.out.println("===== 주문 상세 =====");
        System.out.printf("주문번호: %s \n", this.getOrderId());
        System.out.printf("상품명: %s \n", this.getProductName());
        System.out.printf("브랜드: %s \n", this.getOption());
        System.out.printf("옵션: %s \n", this.getQuantity());
        System.out.printf("수량: %d \n", this.getPrice());
        System.out.printf("금액: %d 원 \n", this.getPrice());
        System.out.printf("주문일: %s \n", this.getOrderDate());
        System.out.printf("상태: %s \n", this.getStatus());
        System.out.printf("지역: %s \n", this.getRegion());
        System.out.println("====================");
    }

    @Override
    public String toString() {
        return "[" + brand + "] " + productName + " - " + String.format("%,d", price) + "원";
    }
}
