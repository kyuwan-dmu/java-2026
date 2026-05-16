package practice02;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 기본 for문으로 전체 주문을 번호와 함께 출력하시오

        // TODO 2: 향상된 for문(for-each)으로 전체 주문을 출력하시오
        for (Order order : orders) {
            System.out.println("[" + order.getBrand()  + "]");
        }
        // TODO 3: 전체 주문 건수를 출력하시오

    }
}
