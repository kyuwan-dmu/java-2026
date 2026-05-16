package practice03;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();
        Order[] selectedOrders = new Order[orders.length];

        int i = 0;
        int totalPrice = 0;
        // TODO 1: 브랜드가 "바디홀릭"인 주문만 출력하시오
        System.out.println("===== 바디홀릭 주문 목록 =====");
        for (Order order : orders){
            if("바디홀릭".equals(order.getBrand()) && order.getPrice() >= 15000){
                selectedOrders[i] = order;
                totalPrice += order.getPrice();
                i ++;
            }
        }
        for(Order selectedOrder : selectedOrders){
            if(selectedOrder != null){
                System.out.println(selectedOrder);
            }
        }
        System.out.println("============================");
        System.out.println("바디홀릭 주문: " + i + "건");
        System.out.println("합계: " + totalPrice + "원");

    }
}
