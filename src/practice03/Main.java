package practice03;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 브랜드가 "바디홀릭"인 주문만 출력하시오
        if (orders.length == 0) {
            System.out.println("주문 데이터가 없습니다. resources/orders.csv를 확인하세요.");
            return;
        }
        System.out.println("===== 바디홀릭 주문 목록 =====");
        for (Order order : orders) {
            if (order.getBrand().equals("바디홀릭")) {
                System.out.println(order.getProductName() + " - " + String.format("%,d", order.getPrice()) + "원 (" + order.getRegion() + ")");
            }
        }
        System.out.println("=========================");
        System.out.println("바디홀릭 주문: " + orders.length + "건");
        // TODO 2: 바디홀릭 주문의 건수와 금액 합계를 출력하시오
        int totalPrice = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getBrand().equals("바디홀릭")) {
                totalPrice += orders[i].getPrice();
            }
        }
        System.out.println("합계: " + String.format("%,d", totalPrice) + "원");

        // TODO 3: 상품금액이 15,000원 이상인 주문만 출력하시오
        int totalPriceOver15000 = 0;

        System.out.println("===== 15,000원 이상 주문 =====");
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getPrice() >= 15000) {
                System.out.println(orders[i].getProductName() + " - " + String.format("%,d", orders[i].getPrice()) + "원 (" + orders[i].getRegion() + ")");
                totalPriceOver15000 += orders[i].getPrice();
            }
        }
        System.out.println("=========================");
        System.out.println("15,000원 이상 주문: " + orders.length + "건");
        System.out.println("합계: " + String.format("%,d", totalPriceOver15000) + "원");
    }
}
