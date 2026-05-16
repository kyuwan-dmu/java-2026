package practice03;

import data.OrderDataProvider;
import model.Order;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        Order[] brandFilteredOrders = Arrays.stream(orders)
                .filter(o -> !Objects.equals(o.getBrand(), "바디홀릭"))
                .toArray(Order[]::new);

        Order[] brandOrders = Arrays.stream(orders)
                .filter(o -> Objects.equals(o.getBrand(), "바디홀릭"))
                .toArray(Order[]::new);

        Order[] priceFilteredOrders = Arrays.stream(orders)
                .filter(o -> o.getPrice() >= 15000)
                .toArray(Order[]::new);

        // TODO 1: 브랜드가 "바디홀릭"인 주문만 출력하시오

        System.out.println("===== 바디홀릭 주문 목록 =====");
        Arrays.stream(brandFilteredOrders).forEach(Order::printOrderInfo);
        System.out.println("============================");

        // TODO 2: 바디홀릭 주문의 건수와 금액 합계를 출력하시오
        long count = Arrays.stream(brandOrders).count();
        System.out.printf("바디홀릭 주문: %d건\n", count);

        long sum = Arrays.stream(brandOrders)
                .mapToInt(Order::getPrice).sum();
        System.out.printf("합계: %,d원\n", sum);


        // TODO 3: 상품금액이 15,000원 이상인 주문만 출력하시오

        System.out.println("===== 바디홀릭 주문 목록 =====");
        Arrays.stream(priceFilteredOrders).forEach(Order::printOrderInfo);
        System.out.println("============================");

    }
}
