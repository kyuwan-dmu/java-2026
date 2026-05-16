package practice02;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 기본 for문으로 전체 주문을 번호와 함께 출력하시오

        // TODO 2: 향상된 for문(for-each)으로 전체 주문을 출력하시오

        // TODO 3: 전체 주문 건수를 출력하시오

        System.out.println("===== 전체 주문 목록 =====");

        int count = 0;
        for(int i=0; i<orders.length; i++) {
            System.out.println(i+1 + ". " + orders[i].getProductName() + " - " + String.format("%,d", orders[i].getPrice()) + "원");
            count++;
        }
        System.out.println("========================");
        System.out.println("총 " + count + "건\n");


        System.out.println("===== 전체 주문 목록 =====");

        count = 0;
        for(Order order : orders) {
            System.out.println(count+1 + ". " + order.getProductName() + " - " + String.format("%,d", order.getPrice()) + "원");
            count++;
        }

        System.out.println("========================");
        System.out.println("총 " + count + "건");
    }
}
