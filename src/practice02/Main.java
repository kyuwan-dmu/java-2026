package practice02;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        if (orders.length == 0) {
            System.out.println("주문 데이터가 없습니다. resources/orders.csv를 확인하세요.");
            return;
        }

        // TODO 1: 기본 for문으로 전체 주문을 번호와 함께 출력하시오
        System.out.println("===== 전체 주문 목록 =====");
        for (int i = 0; i < orders.length; i++) {
            System.out.printf(" %d. %s%n", i + 1, orders[i]);
        }
        System.out.println("========================");

        // TODO 2: 향상된 for문(for-each)으로 전체 주문을 출력하시오
        System.out.println("===== 전체 주문 목록 =====");
        int number = 1;
        for (Order order : orders) {
            System.out.printf(" %d. %s%n", number++, order);
        }
        System.out.println("========================");

        // TODO 3: 전체 주문 건수를 출력하시오
        System.out.println("총 " + orders.length + "건");
    }
}
