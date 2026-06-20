package practice01;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        Order first = orders[0];

        System.out.println("===== 주문 상세 =====");
        System.out.println("주문번호: " + first.getOrderId());
        System.out.println("상품명: " + first.getProductName());
        System.out.println("브랜드: " + first.getBrand());
        System.out.println("옵션: " + (first.getOption().isEmpty() ? "(없음)" : first.getOption()));
        System.out.println("수량: " + first.getQuantity());
        System.out.println("금액: " + String.format("%,d", first.getPrice()) + "원");
        System.out.println("주문일: " + first.getOrderDate());
        System.out.println("상태: " + first.getStatus());
        System.out.println("지역: " + first.getRegion());
        System.out.println("====================");
    }
}
