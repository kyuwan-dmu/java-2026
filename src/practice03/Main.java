package practice03;

import data.OrderDataProvider;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 브랜드가 "바디홀릭"인 주문만 출력하시오
        int BHCount = 0; //브랜드 바디홀릭 카운트
        int BHPrice = 0; //브랜드 바디홀릭 총 가격

        System.out.println("===== 바디홀릭 주문 목록 =====");
        for (int i = 0; i < orders.length; i++) {
            if(orders[i].getBrand().equals("바디홀릭"))
            {
                BHCount++;
                BHPrice += orders[i].getPrice();
                System.out.println(orders[i]+" ("+ orders[i].getRegion()+")");
            }
        }

        // TODO 2: 바디홀릭 주문의 건수와 금액 합계를 출력하시오
        System.out.println("===== 바디홀릭 주문 목록 =====");
        System.out.println("바디홀릭 주문: "+BHCount+"건");
        System.out.println("합계: "+String.format("%,d원", BHPrice));




        // TODO 3: 상품금액이 15,000원 이상인 주문만 출력하시오
        for (int i = 0; i < orders.length; i++) {
            if(orders[i].getBrand().equals("바디홀릭") && orders[i].getPrice() >= 15000)
            {
                System.out.println(orders[i]+" ("+ orders[i].getRegion()+")");
            }
        }
    }
}
