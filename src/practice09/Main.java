package practice09;

import data.OrderDataProvider;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import model.Order;

public class Main {

    private static final int PERFUME_PRICE = 20000;
    private static final int SAMPLE_PRICE = 10000;

    private static final String GIFT_PERFUME = "미니 향수 세트";
    private static final String GIFT_SAMPLE = "샘플 키트";
    private static final String GIFT_NONE = "(사은품 정보 없음)";

    public static void main(String[] args) {
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        if (orders == null || orders.isEmpty()) {
            System.out.println("주문 데이터가 없습니다. resources/orders.csv를 확인하세요.");
            return;
        }

        GiftResult result = classifyOrders(orders);

        printSummary(result, orders.size());
        printGiftCounts(result.giftMap);
        printGiftOrders(result);
        printRegions(result.regions);
    }

    /**
     * 주문 가격에 따라 사은품을 분류해 결과를 모은다.
     */
    private static GiftResult classifyOrders(List<Order> orders) {
        GiftResult result = new GiftResult();

        for (Order order : orders) {
            if (order == null) {
                continue;
            }

            String gift = decideGift(order.getPrice());
            if (gift == null) {
                continue;
            }

            result.giftOrders.add(order);
            result.giftMap.put(order.getOrderId(), gift);
            result.regions.add(order.getRegion());
        }
        return result;
    }

    /**
     * 가격에 해당하는 사은품 이름. 대상이 아니면 null.
     */
    private static String decideGift(int price) {
        if (price >= PERFUME_PRICE) {
            return GIFT_PERFUME;
        }
        if (price >= SAMPLE_PRICE) {
            return GIFT_SAMPLE;
        }
        return null;
    }

    private static void printSummary(GiftResult result, int totalCount) {
        System.out.println("[대상 주문 수] " + result.giftOrders.size() + "건 / 전체 " + totalCount + "건");
    }

    private static void printGiftCounts(Map<String, String> giftMap) {
        int perfumeCount = 0;
        int sampleCount = 0;
        for (String gift : giftMap.values()) {
            if (GIFT_PERFUME.equals(gift)) {
                perfumeCount++; 
            }
            if (GIFT_SAMPLE.equals(gift)) {
                sampleCount++;
            }
        }
        System.out.println("[사은품별 건수]");
        System.out.println(GIFT_PERFUME + ": " + perfumeCount + "건");
        System.out.println(GIFT_SAMPLE + ": " + sampleCount + "건");
    }

    private static void printGiftOrders(GiftResult result) {
        System.out.println("[대상 주문 목록]");

        result.giftOrders.sort(Comparator.comparing(
                Order::getOrderId,
                Comparator.nullsLast(Comparator.naturalOrder())
        ));

        for (Order order : result.giftOrders) {
            String gift = result.giftMap.getOrDefault(order.getOrderId(), GIFT_NONE);
            System.out.println(
                    "주문번호: " + order.getOrderId()
                    + " | [" + order.getBrand() + "] " + order.getProductName()
                    + " - " + String.format("%,d", order.getPrice()) + "원"
                    + " → " + gift
            );
        }
    }

    private static void printRegions(Set<String> regions) {
        System.out.println("[사은품 배송 지역 (중복 제거)]");

        Set<String> sorted = new TreeSet<>(regions);
        for (String region : sorted) {
            System.out.print(region + ", ");
        }
        System.out.println("총 " + regions.size() + "개 지역");
    }

    /**
     * 분류 결과 3종(주문 목록, 주문번호→사은품, 지역)을 묶는다.
     */
    private static class GiftResult {

        final List<Order> giftOrders = new ArrayList<>();
        final Map<String, String> giftMap = new HashMap<>();
        final Set<String> regions = new HashSet<>();
    }
}
