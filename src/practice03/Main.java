package practice03;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();
        Order[] selectedOrders = new Order[orders.length];
        int index=0;

        for (Order order : orders) {
            if("바디홀릭".equals(order.getBrand())){
                System.out.println(selectedOrders[index] = order);
                index++;
            }
        }
        System.out.println("===== 바디홀릭 주문 목록 =====");
        if (selectedOrders != null) {
            for (Order order : selectedOrders) {
                System.out.println();
            }
        }

        // TODO 1: 브랜드가 "바디홀릭"인 주문만 출력하시오

        // TODO 2: 바디홀릭 주문의 건수와 금액 합계를 출력하시오

        // TODO 3: 상품금액이 15,000원 이상인 주문만 출력하시오

    }
}
