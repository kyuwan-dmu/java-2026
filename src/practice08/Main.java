package practice08;

import data.OrderDataProvider;
import model.Order;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = OrderDataProvider.getOrdersAsList();
        NumberFormat nf = NumberFormat.getInstance();

        // TODO 1: Stream으로 바디홀릭 주문만 필터링하여 출력하시오
        System.out.println("===== 1. 바디홀릭 주문 필터링 =====");
        orders.stream()
                .filter(o -> o.getBrand().equals("바디홀릭"))
                .forEach(System.out::println);

        // TODO 2: Stream으로 전체 매출 합계를 구하시오
        System.out.println("\n===== 2. 전체 매출 합계 =====");
        int total = orders.stream()
                .mapToInt(Order::getPrice)
                .sum();
        System.out.println(nf.format(total) + "원");

        // TODO 3: Stream으로 상품금액 내림차순 상위 5건을 출력하시오
        System.out.println("\n===== 3. 금액 상위 5건 =====");
        AtomicInteger rank = new AtomicInteger(1);
        orders.stream()
                .sorted(Comparator.comparingInt(Order::getPrice).reversed())
                .limit(5)
                .forEach(o -> System.out.println(rank.getAndIncrement() + ". " + o));

        // TODO 4: Stream으로 브랜드별 주문 건수를 집계하시오
        System.out.println("\n===== 4. 브랜드별 주문 건수 =====");
        Map<String, Long> brandCount = orders.stream()
                .collect(Collectors.groupingBy(Order::getBrand, Collectors.counting()));
        brandCount.forEach((brand, count) -> System.out.println(brand + ": " + count + "건"));

        // TODO 5: (추가) Stream으로 브랜드별 매출 합계를 구하시오
        System.out.println("\n===== 5. 브랜드별 매출 합계 =====");
        Map<String, Integer> brandTotal = orders.stream()
                .collect(Collectors.groupingBy(Order::getBrand, Collectors.summingInt(Order::getPrice)));
        brandTotal.forEach((brand, sum) -> System.out.println(brand + ": " + nf.format(sum) + "원"));
    }
}