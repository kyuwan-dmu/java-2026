package practice05;

import data.OrderDataProvider;
import model.Order;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        System.out.println("===== 매출 보고서 =====");
        // TODO 1: 전체 매출(상품금액 합계)을 구하시오

        long count = orders.size();
        System.out.printf("전체 주문: %d건\n", count);

        long sum = orders.stream().mapToInt(Order::getPrice).sum();
        System.out.printf("전체 매출: %,d원\n", sum);

        // TODO 2: 전체 평균 주문 금액을 구하시오
        double avg = orders.stream().mapToInt(Order::getPrice).average().getAsDouble();
        System.out.printf("평균 주문 금액: %,.0f원\n", avg);

        System.out.println();

        // TODO 3: 브랜드별 주문 건수와 매출 합계를 구하시오
        System.out.println("--- 브랜드별 ---");
        Map<String, Long> brandGroupCount = orders.stream().collect(Collectors.groupingBy(Order::getBrand, Collectors.counting()));
        Map<String, Integer> brandGroupPrice = orders.stream().collect(Collectors.groupingBy(Order::getBrand, Collectors.summingInt(Order::getPrice)));

        for (String key : brandGroupCount.keySet()) {
            long brandCount = brandGroupCount.get(key);
            int branchPrice = brandGroupPrice.get(key);
            System.out.printf("%s: %d건 / %,d원\n", key, brandCount, branchPrice);
        };




        System.out.println();

        // TODO 4: 지역별 주문 건수를 구하시오
        System.out.println("--- 지역별 주문 건수 ---");
        Map<String, Long> reginGroupCount = orders.stream().collect(Collectors.groupingBy(Order::getRegion, Collectors.counting()));
        for (Map.Entry<String, Long> entry : reginGroupCount.entrySet()) {
            System.out.printf("%s: %d건\n", entry.getKey(), entry.getValue());
        }

        System.out.println("========================");

        // TODO 5: (추가) 가장 매출이 높은 브랜드를 찾아 출력하시오

        String topBrand =
                orders.stream()
                        .collect(Collectors.groupingBy(Order::getBrand, Collectors.summingInt(Order::getPrice)))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse("");
        System.out.println(topBrand);

//        ===== 매출 보고서 =====
//        전체 주문: 74건
//        전체 매출: 1,264,000원
//        평균 주문 금액: 17,081원
//
//                --- 브랜드별 ---
//                바디홀릭: 65건 / 1,106,400원
//        머지: 9건 / 157,600원
//
//                --- 지역별 주문 건수 ---
//                경기: 12건
//        서울: 8건
//        부산: 7건
//...

    }
}
