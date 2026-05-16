package practice01;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();
        Order firstOrder = orders[0];
        // TODO: 첫 번째 주문을 변수에 담고, 모든 정보를 출력하시오

//        public static void isOption (firstOrder.getOption){
//            if(firstOrder.getOption === "" || firstOrder.getOption === NULL){
//                System.out.println("옵션 : (없음)");
//            }
//        } 외않됌?

        String option = firstOrder.getOption();
        int price = firstOrder.getPrice();
        String calcPrice = String.format("%,d",firstOrder.getPrice());

        if (option == null || option.isEmpty()){
            option = "(없음)";
        }

        System.out.println("==== 주문 상세 ====");
        System.out.println("주문번호 : " + firstOrder.getOrderId());
        System.out.println("상품명 : " + firstOrder.getProductName());
        System.out.println("브랜드 : " + firstOrder.getBrand());
        System.out.println("옵션 : " + option);
        System.out.println("수량 : " + firstOrder.getQuantity());
        System.out.println("금액 : " + calcPrice);
        System.out.println("주문일 : " + firstOrder.getOrderDate());
        System.out.println("상태 : " + firstOrder.getStatus());
        System.out.println("지역 : " + firstOrder.getRegion());
        System.out.println("====================\n");
    }
}
