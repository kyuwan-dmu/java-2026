package practice04;

import data.OrderDataProvider;
import model.Order;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        System.out.println("현재 주문 건수: " + orders.size() + "건");

        System.out.println();
        System.out.println("[신규 주문 추가]");
        orders.add(new Order("9999999", "테스트 상품A", "", 1, "머지", 15000, "2024-08-28 09:00:00", "301 배송 준비 중", "서울 강남구"));
        orders.add(new Order("9999998", "테스트 상품B", "", 2, "바디홀릭", 20000, "2024-08-28 10:00:00", "301 배송 준비 중", "부산 해운대구"));
        System.out.println("추가 후 건수: " + orders.size() + "건");

        System.out.println();
        System.out.println("[첫 번째 주문 삭제]");
        orders.remove(0);
        System.out.println("삭제 후 건수: " + orders.size() + "건");

        System.out.println();
        System.out.println("===== 전체 주문 =====");
        for (Order o : orders) {
            System.out.printf("[%s] %s - %,d원%n", o.getBrand(), o.getProductName(), o.getPrice());
        }
        System.out.println("====================");
    }
}
