package practice02;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        System.out.println("===== 전체 주문 목록 =====");
        for (int i = 0; i < orders.length; i++) {
            Order o = orders[i];
            System.out.printf("%2d. [%s] %s - %,d원%n",
                    i + 1, o.getBrand(), o.getProductName(), o.getPrice());
        }
        System.out.println("========================");

        System.out.println();

        System.out.println("===== 전체 주문 목록 (for-each) =====");
        for (Order o : orders) {
            System.out.printf("[%s] %s - %,d원%n",
                    o.getBrand(), o.getProductName(), o.getPrice());
        }
        System.out.println("========================");

        System.out.println("총 " + orders.length + "건");
    }
}
