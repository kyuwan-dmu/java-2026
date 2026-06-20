package practice06;

import data.OrderDataProvider;
import model.Order;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        Collections.sort(orders, (o1, o2) -> o1.getOrderDate().compareTo(o2.getOrderDate()));
        System.out.println("===== 주문일 오름차순 (오래된 주문 먼저) =====");
        for (int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            System.out.printf("%2d. %s | [%s] %s - %,d원%n",
                    i + 1, o.getOrderDate(), o.getBrand(), o.getProductName(), o.getPrice());
        }

        System.out.println();

        Collections.sort(orders, (o1, o2) -> o2.getPrice() - o1.getPrice());
        System.out.println("===== 상품금액 내림차순 (비싼 주문 먼저) =====");
        for (int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            System.out.printf("%2d. [%s] %s - %,d원%n",
                    i + 1, o.getBrand(), o.getProductName(), o.getPrice());
        }

        System.out.println();

        Collections.sort(orders, Comparator.comparing(Order::getBrand)
                .thenComparing(Comparator.comparingInt(Order::getPrice).reversed()));
        System.out.println("===== 브랜드별 → 금액 내림차순 =====");
        String currentBrand = "";
        for (int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            if (!o.getBrand().equals(currentBrand)) {
                currentBrand = o.getBrand();
                System.out.println("[" + currentBrand + "]");
            }
            System.out.printf("%2d. %s - %,d원%n", i + 1, o.getProductName(), o.getPrice());
        }

        System.out.println();

        System.out.println("===== 상위 5건 =====");
        Collections.sort(orders, (o1, o2) -> o2.getPrice() - o1.getPrice());
        for (int i = 0; i < 5; i++) {
            Order o = orders.get(i);
            System.out.printf("%d. [%s] %s - %,d원%n",
                    i + 1, o.getBrand(), o.getProductName(), o.getPrice());
        }
    }
}
