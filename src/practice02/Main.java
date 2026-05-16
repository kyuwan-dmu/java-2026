package practice02;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();


        //for
        System.out.println("===== 전체 주문 목록 =====");
        for (int i = 0; i < orders.length; i++) {
            System.out.println(orders[i]);
        }
        System.out.println("========================");
        System.out.println("총 "+orders.length+"건");





        //foreach
        System.out.println("===== 전체 주문 목록 =====");
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println("========================");
        System.out.println("총 "+orders.length+"건");
    }
}
