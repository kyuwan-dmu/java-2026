package practice06;

import data.OrderDataProvider;
import model.Order;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    private enum PrintStyle {
        WITH_ORDER_DATE,
        NUMBERED,
        BY_BRAND_SECTION
    }

    public static void main(String[] args) {
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: 주문일 오름차순으로 정렬하여 출력하시오
        sortAndPrint(
                orders,
                Comparator.comparing(Order::getOrderDate),
                "주문일 오름차순 (오래된 주문 먼저)",
                PrintStyle.WITH_ORDER_DATE);

        // TODO 2: 상품금액 내림차순으로 정렬하여 출력하시오
        sortAndPrint(
                orders,
                (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()),
                "상품금액 내림차순 (비싼 주문 먼저)",
                PrintStyle.NUMBERED);

        // TODO 3: 브랜드별 오름차순 → 같은 브랜드 내 금액 내림차순 정렬하시오
        sortAndPrint(
                orders,
                Comparator.comparing(Order::getBrand)
                        .thenComparing(Comparator.comparingInt(Order::getPrice).reversed()),
                "브랜드별 → 금액 내림차순",
                PrintStyle.BY_BRAND_SECTION);

        // TODO 4: (추가) 정렬 후 상위 5건만 출력하시오
        Collections.sort(orders, (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()));
        printTop(orders, 5);
    }

    private static void sortAndPrint(
            List<Order> orders,
            Comparator<Order> comparator,
            String title,
            PrintStyle style) {
        Collections.sort(orders, comparator);
        System.out.println("===== " + title + " =====");
        printOrders(orders, style);
        System.out.println();
    }

    private static void printOrders(List<Order> orders, PrintStyle style) {
        switch (style) {
            case WITH_ORDER_DATE -> printWithOrderDate(orders);
            case NUMBERED -> printNumbered(orders);
            case BY_BRAND_SECTION -> printByBrandSection(orders);
        }
    }

    private static void printWithOrderDate(List<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.printf(
                    " %d. %s | %s%n",
                    i + 1,
                    order.getOrderDate(),
                    order);
        }
    }

    private static void printNumbered(List<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            System.out.printf(" %d. %s%n", i + 1, orders.get(i));
        }
    }

    private static void printByBrandSection(List<Order> orders) {
        String currentBrand = null;
        int indexInBrand = 0;

        for (Order order : orders) {
            String brand = order.getBrand();
            if (!brand.equals(currentBrand)) {
                currentBrand = brand;
                indexInBrand = 0;
                System.out.println("[" + brand + "]");
            }
            indexInBrand++;
            System.out.printf(
                    " %d. %s - %s%n",
                    indexInBrand,
                    order.getProductName(),
                    formatPrice(order.getPrice()));
        }
    }

    private static void printTop(List<Order> orders, int count) {
        int limit = Math.min(count, orders.size());
        for (int i = 0; i < limit; i++) {
            System.out.printf(" %d. %s%n", i + 1, orders.get(i));
        }
    }

    private static String formatPrice(int price) {
        return String.format("%,d", price) + "원";
    }
}
