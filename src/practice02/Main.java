package practice02;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 기본 for문으로 전체 주문을 번호와 함께 출력하시오
        Order firstOrder = orders[0];
        System.out.println(" ===== 전체 주문 목록 =====" );

        int total = 0;

        for (int i = 0; i < orders.length; i ++){
            Order currentOrder = orders[i];
            String option = currentOrder.getOption();
            int price = currentOrder.getPrice();
            String calcPrice = String.format("%,d", price);

            if (option == null || option.isEmpty()) {
                option = "(없음)";
            }

            System.out.println("상품명 : " + orders[i].getProductName());
            System.out.println("브랜드 : " + orders[i].getBrand());
            System.out.println("수량 : " + orders[i].getQuantity());
            System.out.println("금액 : " + calcPrice);

            total +=1;
        }
        System.out.println("========================");
        System.out.println("총 " + total+"건");
        total = 0;
        // TODO 2: 향상된 for문(for-each)으로 전체 주문을 출력하시오
        System.out.println(" ===== 전체 주문 목록 =====" );
        for (Order order : orders){
            String option = order.getOption();
            int price = order.getPrice();
            String calcPrice = String.format("%,d", price);

            if (option == null || option.isEmpty()) {
                option = "(없음)";
            }
            System.out.println(order);
            total +=1;

        }
        // TODO 3: 전체 주문 건수를 출력하시오
        System.out.println("========================");
        System.out.println("총 " + total+"건");
        total = 0;
    }
}
