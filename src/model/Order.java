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
  private String gift;

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
    this.gift = isGift(price);
  }

  private String isGift(int price) {

    if (price >= 20000) {
      return "미니 향수 세트";
    }

    if (price >= 10000 && price <= 20000) {
      return "샘플 키트";
    }

    return "대상 아님";
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

  public String getGift() {
    return gift;
  }

  public void setGift(String gift) {
    this.gift = gift;
  }

  @Override
  public String toString() {
    return "주문번호: " + orderId + "[" + brand + "] " + productName + " - " + String.format("%,d",price) + "원 -> " + gift;
  }
}
