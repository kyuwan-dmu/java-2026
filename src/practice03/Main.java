package practice03;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 리스트를 활용한 풀이도 해보기
        Order[] orders = OrderDataProvider.getOrdersAsArray();
        Order[] selectedOrders = new Order[orders.length];
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
