package practice02;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 기본 for문으로 전체 주문을 번호와 함께 출력하시오
        if (orders.length == 0) {
            System.out.println("주문 데이터가 없습니다. resources/orders.csv를 확인하세요.");
            return;
        }
        System.out.println("===== 전체 주문 목록 =====");
        for (int i = 0; i < orders.length; i++) {
            System.out.println((i + 1) + ". " + orders[i].getProductName());
        }
        System.out.println("=========================");
        System.out.println("총 " + orders.length + "건");
        // TODO 2: 향상된 for문(for-each)으로 전체 주문을 출력하시오
        int i = 1;
        System.out.println("===== 전체 주문 목록 =====");
        for (Order order : orders) {
            System.out.println(i + ". " + order.getProductName());
            i++;
        }
        System.out.println("=========================");
        // TODO 3: 전체 주문 건수를 출력하시오
        System.out.println("총 " + orders.length + "건");
    }
}
