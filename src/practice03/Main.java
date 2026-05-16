package practice03;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 브랜드가 "바디홀릭"인 주문만 출력하시오
        int count = 0;
        int totalPrice = 0;
        System.out.println("===== 전체 주문 목록 =====");
        for(int i = 0; i < orders.length; i++){
            if(orders[i].getBrand().equals("바디홀릭")){
                count++;
                System.out.println("[바디홀릭] " + orders[i].getProductName() + " - "+String.format("%,d",orders[i].getPrice()) + "(" + orders[i].getRegion()+")");
                totalPrice += orders[i].getPrice();
            }

        }
        System.out.println("========================");

        // TODO 2: 바디홀릭 주문의 건수와 금액 합계를 출력하시오
        System.out.println("바디홀릭 주문: " + count+"건");
        System.out.println("합계: " + String.format("%,d", totalPrice)+"원");
        System.out.println("");


        // TODO 3: 상품금액이 15,000원 이상인 주문만 출력하시오
        System.out.println("===== 15,000원 이상 주문 =====");
        for(int i = 0; i < orders.length; i++){
            if(orders[i].getBrand().equals("바디홀릭") && orders[i].getPrice() >= 15000){
                count++;
                System.out.println("[바디홀릭] " + orders[i].getProductName() + " - "+String.format("%,d",orders[i].getPrice()) + "(" + orders[i].getRegion()+")");
                totalPrice += orders[i].getPrice();
            }

        }
        System.out.println("========================");

    }
}
