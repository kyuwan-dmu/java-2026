package practice01;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        System.out.println("===== 주문 상세 =====");
        System.out.println("주문번호: " + orders[0].getOrderId());
        System.out.println("상품명: " + orders[0].getProductName());
        System.out.println("브랜드: " + orders[0].getBrand());
        System.out.println("옵션: " + (orders[0].getOption().isEmpty() ? "(없음)" : orders[0].getOption()));
        System.out.println("수량: " + orders[0].getQuantity());
        System.out.println("금액: " + String.format("%,d",orders[0].getPrice()));
        System.out.println("주문일: " + orders[0].getOrderDate());
        System.out.println("상태: " + orders[0].getStatus());
        System.out.println("지역: " + orders[0].getRegion());
        System.out.println("====================");
        // TODO: 첫 번째 주문을 변수에 담고, 모든 정보를 출력하시오
    }

}
