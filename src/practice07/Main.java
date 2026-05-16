package practice07;

import data.OrderDataProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        List<Order> orders = OrderDataProvider.getOrdersAsList();
        Map<String, Integer> brandCount = new HashMap<>();
        Map<String, Integer> brandSales = new HashMap<>();
        Map<String, Integer> regionCount = new HashMap<>();
        Map<String, Integer> productCount = new HashMap<>();
        for (Order order : orders) {
            brandCount.put(order.getBrand(), brandCount.getOrDefault(order.getBrand(), 0) + 1);
            brandSales.put(order.getBrand(), brandSales.getOrDefault(order.getBrand(), 0) + order.getPrice());
            regionCount.put(order.getRegion(), regionCount.getOrDefault(order.getRegion(), 0) + 1);
            productCount.put(order.getProductName(), productCount.getOrDefault(order.getProductName(), 0) + 1);
        }

        // TODO 1: 브랜드별 주문 건수를 Map으로 집계하시오
        System.out.println("===== 브랜드별 주문 건수 =====\n");
        for (Map.Entry<String, Integer> entry : brandCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "건");
        }
        System.out.println("============================\n");

        // TODO 2: 브랜드별 매출 합계를 Map으로 집계하시오
        System.out.println("===== 브랜드별 매출 합계 =====\n");
        for (Map.Entry<String, Integer> entry : brandSales.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.format("%,d", entry.getValue()) + "원");
        }
        System.out.println("============================\n");

        // TODO 3: 지역별 주문 건수를 Map으로 집계하시오
        System.out.println("===== 지역별 주문 건수 =====\n");
        for (Map.Entry<String, Integer> entry : regionCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "건");
        }
        System.out.println("============================\n");

        // TODO 4: 각 Map의 내용을 출력하시오
        System.out.println("===== 브랜드별 주문 건수 =====\n");
        for (Map.Entry<String, Integer> entry : brandCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "건");
        }
        System.out.println("============================\n");

        // TODO 5: (추가) 상품명별 주문 건수 상위 3개를 출력하시오
        List<Map.Entry<String, Integer>> productRanking = new ArrayList<>(productCount.entrySet());
        productRanking.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("===== 인기 상품 TOP 3 =====\n");
        int topCount = Math.min(3, productRanking.size());
        for (int i = 0; i < topCount; i++) {
            Map.Entry<String, Integer> entry = productRanking.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + ": " + entry.getValue() + "건");
        }
    }
}
