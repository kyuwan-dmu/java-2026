package practice02;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 기본 for문으로 전체 주문을 번호와 함께 출력하시오
        int num = 0;
        System.out.println("===== 전체 주문 목록 =====");
        for(int i = 0; i < orders.length; i++){
            num++;
            System.out.println(num+". " + orders[i].getProductName() + " - "+String.format("%,d",orders[i].getPrice()));
        }
        System.out.println("========================");

        // TODO 2: 향상된 for문(for-each)으로 전체 주문을 출력하시오
        int j = 0;
        int num1 = 0;
        System.out.println("===== 전체 주문 목록 =====");
        for(Order order : orders){
            num1++;
            System.out.println(num1+". " + orders[j].getProductName() + " - "+String.format("%,d",orders[j].getPrice()));
            j++;
        }
        System.out.println("========================");
        // TODO 3: 전체 주문 건수를 출력하시오
        System.out.println("총 " + num + "건");
    }
}
