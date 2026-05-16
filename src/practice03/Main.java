package practice03;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 브랜드가 "바디홀릭"인 주문만 출력하시오

        // TODO 2: 바디홀릭 주문의 건수와 금액 합계를 출력하시오

        // TODO 3: 상품금액이 15,000원 이상인 주문만 출력하시오
        System.out.println("===== 바디홀릭 주문 목록 =====");

        int count = 0, sum = 0;
        for(Order order : orders) {
            if(order.getBrand().equals("바디홀릭")) {
                System.out.println(order.toString());
                sum += order.getPrice();
                count++;
            }
        }
        System.out.println("============================");
        System.out.println("바디홀릭 주문: " + count + "건");
        System.out.println("합계: " + String.format("%,d\n", sum));

        System.out.println("===== 15,000원 이상 주문 =====");
        count = 0;
        sum = 0;
        for(Order order : orders) {
            if(order.getBrand().equals("바디홀릭")) {
                if(15000 <= order.getPrice()) {
                    System.out.println(order.toString());
                    sum += order.getPrice();
                    count++;
                }
            }
        }
        System.out.println("바디홀릭 주문: " + count + "건");
        System.out.println("합계: " + String.format("%,d\n", sum));

    }
}
