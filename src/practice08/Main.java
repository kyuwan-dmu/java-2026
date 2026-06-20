package practice08;

import data.OrderDataProvider;
import model.Order;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        System.out.println("===== 1. 바디홀릭 주문 필터링 =====");
        orders.stream()
                .filter(o -> o.getBrand().equals("바디홀릭"))
                .forEach(o -> System.out.printf("[%s] %s - %,d원%n",
                        o.getBrand(), o.getProductName(), o.getPrice()));

        System.out.println();
        System.out.println("===== 2. 전체 매출 합계 =====");
        int total = orders.stream()
                .mapToInt(Order::getPrice)
                .sum();
        System.out.printf("%,d원%n", total);

        System.out.println();
        System.out.println("===== 3. 금액 상위 5건 =====");
        List<Order> top5 = orders.stream()
                .sorted(Comparator.comparingInt(Order::getPrice).reversed())
                .limit(5)
                .collect(Collectors.toList());
        for (int i = 0; i < top5.size(); i++) {
            Order o = top5.get(i);
            System.out.printf("%d. [%s] %s - %,d원%n",
                    i + 1, o.getBrand(), o.getProductName(), o.getPrice());
        }

        System.out.println();
        System.out.println("===== 4. 브랜드별 주문 건수 =====");
        Map<String, Long> brandCount = orders.stream()
                .collect(Collectors.groupingBy(Order::getBrand, Collectors.counting()));
        brandCount.forEach((brand, count) -> System.out.println(brand + ": " + count + "건"));

        System.out.println();
        System.out.println("===== 5. 브랜드별 매출 합계 =====");
        Map<String, Integer> brandTotal = orders.stream()
                .collect(Collectors.groupingBy(Order::getBrand, Collectors.summingInt(Order::getPrice)));
        brandTotal.forEach((brand, sum) -> System.out.printf("%s: %,d원%n", brand, sum));
    }
}
