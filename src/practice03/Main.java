package practice03;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        System.out.println("===== 바디홀릭 주문 목록 =====");
        int count = 0;
        int total = 0;
        for (Order o : orders) {
            if (o.getBrand().equals("바디홀릭")) {
                System.out.printf("[%s] %s - %,d원 (%s)%n",
                        o.getBrand(), o.getProductName(), o.getPrice(), o.getRegion());
                count++;
                total += o.getPrice();
            }
        }
        System.out.println("============================");
        System.out.println("바디홀릭 주문: " + count + "건");
        System.out.println("합계: " + String.format("%,d", total) + "원");

        System.out.println();

        System.out.println("===== 15,000원 이상 주문 =====");
        for (Order o : orders) {
            if (o.getPrice() >= 15000) {
                System.out.printf("[%s] %s - %,d원%n",
                        o.getBrand(), o.getProductName(), o.getPrice());
            }
        }
    }
}
