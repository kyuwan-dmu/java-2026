package practice03;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();
        Order[] selectedOrders = new Order[orders.length];
        // TODO 1: 브랜드가 "바디홀릭"인 주문만 출력하시오
        int index = 0;
        int totalPrice = 0;
        int orderCount = 0;
        for(Order order:orders){
            if("바디홀릭".equals(order.getBrand()) && order.getPrice() >= 15000 ){
                selectedOrders[index] = order;
                index += 1;
                totalPrice += order.getPrice();
                orderCount += 1;
                System.out.println(order);
            }
        }
        System.out.println("===== 바디홀릭 주문 목록 =====");
        for(Order selectedorder: selectedOrders){
            if(selectedorder != null){
                System.out.println(selectedorder);
            }

        }
        System.out.println("============================");
        System.out.println("바디홀릭 주문 : " + orderCount + "건");
        System.out.println("합계 : " + totalPrice + "원");


    }
}
