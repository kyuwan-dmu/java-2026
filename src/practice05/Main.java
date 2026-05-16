package practice05;

import data.OrderDataProvider;
import model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        // TODO 1: 전체 매출(상품금액 합계)을 구하시오
        int count = 0;
        int totalPrice = 0;
        for(int i = 0; i < orders.length; i++){
                count++;
                totalPrice += orders[i].getPrice();
        }
        System.out.println("전체 주문: " + count +"건");
        System.out.println("전체 매출: " + String.format("%,d", totalPrice)+"원");

        // TODO 2: 전체 평균 주문 금액을 구하시오
        System.out.println("평균 주문 금액: " + String.format("%,d", totalPrice/count)+"원");

        // TODO 3: 브랜드별 주문 건수와 매출 합계를 구하시오
        count = 0;
        totalPrice = 0;

        System.out.println("--- 브랜드별 ---");
        for(int i = 0; i < orders.length; i++){
            if(orders[i].getBrand().equals("바디홀릭")){
                count++;
                totalPrice += orders[i].getPrice();

            }
        }
        System.out.println("바디홀릭: " +count + "건/ " +String.format("%,d", totalPrice)+"원");

        count = 0;
        totalPrice = 0;

        for(int i = 0; i < orders.length; i++){
            if(orders[i].getBrand().equals("머지")){
                count++;
                totalPrice += orders[i].getPrice();
            }
        }
        System.out.println("머지: " +count + "건/ " +String.format("%,d", totalPrice)+"원");
        // TODO 4: 지역별 주문 건수를 구하시오
        System.out.println("--- 지역별 주문 건수 ---");


        Map<String, Integer> regionMap = new HashMap<>();

        for (int i = 0; i < orders.length; i++) {
            String region = orders[i].getRegion();
            regionMap.put(region, regionMap.getOrDefault(region, 0) + 1);
        }

        for (String region : regionMap.keySet()) {
            System.out.println(region + ": " + regionMap.get(region) + "건");
        }
        // TODO 5: (추가) 가장 매출이 높은 브랜드를 찾아 출력하시오
        int bodyHolicPrice = 0; int mergePrice = 0; count =0; int count1 = 0;
        for(int i = 0; i < orders.length; i++){
            if(orders[i].getBrand().equals("바디홀릭")){
                count++;
                bodyHolicPrice += orders[i].getPrice();
            } else if(orders[i].getBrand().equals("머지")){
                count1++;
                mergePrice += orders[i].getPrice();

            }
        }
        if(bodyHolicPrice > mergePrice){
            System.out.println("바디홀릭: " +count + "건/ " +String.format("%,d", totalPrice)+"원");
        }else{
            System.out.println("머지: " +count1 + "건/ " +String.format("%,d", totalPrice)+"원");
        }
    }
}
