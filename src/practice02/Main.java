package practice02;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 기본 for문으로 전체 주문을 번호와 함께 출력하시오

        System.out.println("===== 전체 주문 목록 =====");
        for (int i=0; i<orders.length; i++) {
            System.out.printf("%d. ", i+1); orders[i].printOrderInfo();
        }
        System.out.println("========================");


        // TODO 2: 향상된 for문(for-each)으로 전체 주문을 출력하시오

//        System.out.println("===== 전체 주문 목록 =====");
//        int num = 1;
//        for (Order order : orders) {
//            System.out.printf("%d. ", num); order.printOrderInfo();
//            num++;
//        }
//        System.out.println("========================");

        // TODO 3: 전체 주문 건수를 출력하시오
        System.out.printf("총 %d건", orders.length);

    }
}
