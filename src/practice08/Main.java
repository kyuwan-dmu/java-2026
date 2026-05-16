package practice08;

import data.OrderDataProvider;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: Stream으로 바디홀릭 주문만 필터링하여 출력하시오
        System.out.println("===== 1. 바디홀릭 주문 필터링 =====\n");
        orders.stream()
                .filter(o -> o.getBrand().equals("바디홀릭"))
                .forEach(System.out::println);
        System.out.println("============================\n");

        // TODO 2: Stream으로 전체 매출 합계를 구하시오
        System.out.println("===== 2. 전체 매출 합계 =====\n");
        int totalSales = orders.stream()
                .mapToInt(Order::getPrice)
                .sum();
        System.out.println(String.format("%,d", totalSales) + "원\n");

        // TODO 3: Stream으로 상품금액 내림차순 상위 5건을 출력하시오
        System.out.println("===== 3. 금액 상위 5건 =====\n");
        List<Order> top5 = orders.stream()
                .sorted(Comparator.comparingInt(Order::getPrice).reversed())
                .limit(5)
                .toList();
        for (int i = 0; i < top5.size(); i++) {
            System.out.printf(" %d. %s%n", i + 1, top5.get(i));
        }
        System.out.println("============================\n");
        // TODO 4: Stream으로 브랜드별 주문 건수를 집계하시오
        System.out.println("===== 4. 브랜드별 주문 건수 =====\n");
        Map<String, Long> brandCount = orders.stream()
                .collect(Collectors.groupingBy(Order::getBrand, Collectors.counting()));
        for (Map.Entry<String, Long> entry : brandCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "건");
        }
        System.out.println("============================\n");
        // TODO 5: (추가) Stream으로 브랜드별 매출 합계를 구하시오
        System.out.println("===== 5. 브랜드별 매출 합계 =====\n");
        Map<String, Integer> brandTotal = orders.stream()
                .collect(Collectors.groupingBy(Order::getBrand, Collectors.summingInt(Order::getPrice)));
        for (Map.Entry<String, Integer> entry : brandTotal.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.format("%,d", entry.getValue()) + "원");
        }
        System.out.println("============================\n");
    }
}
