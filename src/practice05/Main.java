package practice05;

import data.OrderDataProvider;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: 전체 매출(상품금액 합계)을 구하시오
        System.out.println("===== 매출 보고서 =====");

        int totalPrice = 0; //전체 매출
        System.out.println("전체 주문: "+orders.size()+"건");

        //List에서 한번에 계산하고 싶지만.. 우찌 하는지 모름(되는지도 모름 ㅎㅎ...) + stream? 쓰면 된다고 하네여....
        for(Order order : orders) {
            totalPrice += order.getPrice();
        }

        System.out.println("전체 매출: " + String.format("%,d원", totalPrice));


        // TODO 2: 전체 평균 주문 금액을 구하시오
        System.out.println("평균 주문 금액: " + String.format("%,d원", totalPrice/orders.size())+"\n");

        // TODO 3: 브랜드별 주문 건수와 매출 합계를 구하시오
        System.out.println("--- 브랜드별 ---");
        int bodyHolicCount = 0;
        int bodyHolicTotal = 0;

        int mergeCount = 0;
        int mergeTotal = 0;

        for(Order order : orders) {
            if(order.getBrand().equals("바디홀릭"))
            {
                bodyHolicCount++;
                bodyHolicTotal += order.getPrice();
            }
            if(order.getBrand().equals("머지"))
            {
                mergeCount++;
                mergeTotal += order.getPrice();
            }
        }

        System.out.println("바디홀릭: "+bodyHolicCount+"건 / " + String.format("%,d원", bodyHolicTotal));
        System.out.println("머지: "+mergeCount+"건 / " + String.format("%,d원", mergeTotal)+"\n");


        // TODO 4: 지역별 주문 건수를 구하시오
        List<String> regions = new ArrayList<>();               //주소
        List<Integer> regionsCount = new ArrayList<>();         //주소별 개수

        for (Order order : orders) {
            int spaceIdx = order.getRegion().indexOf(" ");      //주소를 스페이스바로 나누기.

            if(!regions.contains(order.getRegion().substring(0, spaceIdx))) {   //regions 에 주소 앞자리가 없다면.
                regions.add(order.getRegion().substring(0, spaceIdx));          //regions 에 주소 앞자리 추가
                regionsCount.add(1);                                            //regionsCount 값 1 추가(새로운 주소는 마지막 위치에 추가. region과 같은 index에 들어가짐.)
            }
            else {
                int index = regions.indexOf(order.getRegion().substring(0, spaceIdx));  //regions 에 이미 있는 값이니 regions에 있는 값에 index 값고 옴.
                regionsCount.set(index, index+1);                                       //regions 와 regionCount 에 index는 연동 되니 regions 에서 갖고 온 index에 값 1 추가
            }
        }

        System.out.println("--- 지역별 주문 건수 ---");

        for (int i = 0; i < regions.size(); i++) {
            System.out.println(regions.get(i)+": "+regionsCount.get(i)+"건");    //둘은 index가 같으니 가능함.
        }
        System.out.println("========================\n");

        // TODO 5: (추가) 가장 매출이 높은 브랜드를 찾아 출력하시오
        // (TODO 4 에서 모든 힘을 써버렸어요.. ㅎㅎ...)
        System.out.println("--- 가장 매출이 높은 브랜드 ---");
        if(bodyHolicTotal>mergeTotal) {
            System.out.println("바디홀릭");
        }
        else {
            System.out.println("머지");
        }
    }
}