package practice09;

import data.OrderDataProvider;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import model.Order;

public class Main {

    private static final String GIFT_PERFUME = "미니 향수 세트";
    private static final String GIFT_SAMPLE = "샘플 키트";
    private static final String GIFT_NONE = "대상 아님";

    public static void main(String[] args) {
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        if (orders == null || orders.isEmpty()) {
            System.out.println("주문 데이터가 없습니다. resources/orders.csv를 확인하세요.");
            return;
        }

        GiftResult result = classifyOrders(orders);

        System.out.println("===== 사은품 지급 이벤트 처리 =====");
        printSummary(result, orders.size());
        printGiftCounts(result.giftOrders);
        printGiftOrders(result.giftOrders);
        printRegions(result.regions);
    }

    /**
     * Order.getGift() 값을 기준으로 사은품 대상 주문과 배송 지역을 모은다.
     */
    private static GiftResult classifyOrders(List<Order> orders) {
        GiftResult result = new GiftResult();

        for (Order order : orders) {
            if (order == null || isNotEligible(order)) {
                continue;
            }
            result.giftOrders.add(order);
            result.regions.add(order.getRegion());
        }
        return result;
    }

    private static boolean isNotEligible(Order order) {
        String gift = order.getGift();
        return gift == null || GIFT_NONE.equals(gift);
    }

    private static void printSummary(GiftResult result, int totalCount) {
        System.out.println("[대상 주문 수] " + result.giftOrders.size() + "건 / 전체 " + totalCount + "건");
    }

    private static void printGiftCounts(List<Order> giftOrders) {
        long perfumeCount = giftOrders.stream()
                .filter(o -> GIFT_PERFUME.equals(o.getGift()))
                .count();
        long sampleCount = giftOrders.stream()
                .filter(o -> GIFT_SAMPLE.equals(o.getGift()))
                .count();

        System.out.println("\n[사은품별 건수]");
        System.out.println(GIFT_PERFUME + ": " + perfumeCount + "건");
        System.out.println(GIFT_SAMPLE + ": " + sampleCount + "건");
    }

    private static void printGiftOrders(List<Order> giftOrders) {
        System.out.println("\n[대상 주문 목록]");

        giftOrders.sort(Comparator.comparing(
                Order::getOrderId,
                Comparator.nullsLast(Comparator.naturalOrder())
        ));

        for (Order order : giftOrders) {
            System.out.println(order);
        }
    }

    private static void printRegions(Set<String> regions) {
        System.out.println("\n[사은품 배송 지역 (중복 제거)]");

        Set<String> sorted = new TreeSet<>(regions);
        for (String region : sorted) {
            System.out.print(region + ", ");
        }
        System.out.println("총 " + regions.size() + "개 지역");
    }

    /**
     * 분류 결과(주문 목록, 지역)를 묶는다.
     */
    private static class GiftResult {

        final List<Order> giftOrders = new ArrayList<>();
        final Set<String> regions = new HashSet<>();
    }
}
