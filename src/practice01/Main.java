package practice01;

import data.OrderDataProvider;
import model.Order;

import javax.management.Query;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO: 첫 번째 주문을 변수에 담고, 모든 정보를 출력하시오 

    for(Order order : orders) {
        System.out.println("\n===== 주문 상세 =====");
        System.out.println("주문번호 :" + order.getOrderId());
        System.out.println("상품명 :" + order.getProductName());
        System.out.println("브랜드 :" + order.getBrand());
        System.out.println("옵션 :" + order.getOption());
        System.out.println("수량 :" + order.getQuantity());
        System.out.println("금액 :" + order.getPrice());
        System.out.println("주문일 :" + order.getOrderDate());
        System.out.println("상태 :" + order.getStatus());
        System.out.println("지역 :" + order.getRegion());
        System.out.println("====================\n");
    }
    }
}
