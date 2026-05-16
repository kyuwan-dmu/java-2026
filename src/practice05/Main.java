package practice05;

import data.OrderDataProvider;
import java.util.ArrayList;
import java.util.List;
import model.Order;

public class Main {

    private static final String BRAND_BODY_HOLIC = "바디홀릭";
    private static final String BRAND_MERGE = "머지";
    private static final String UNKNOWN_PROVINCE = "미상";

    public static void main(String[] args) {
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        if (orders.isEmpty()) {
            System.out.println("주문 데이터가 없습니다.");
            return;
        }

        // TODO 1: 전체 매출(상품금액 합계)
        int totalSales = sumPrices(orders);

        // TODO 2: 전체 평균 주문 금액
        double averageSales = calculateAverage(totalSales, orders.size());

        // TODO 3: 브랜드별 주문 건수와 매출 합계
        BrandStats bodyHolic = aggregateByBrand(orders, BRAND_BODY_HOLIC);
        BrandStats merge = aggregateByBrand(orders, BRAND_MERGE);

        // TODO 4: 지역별 주문 건수 (시/도 단위)
        List<String> provinces = collectProvinces(orders);
        int[] provinceCounts = countByProvinces(orders, provinces);

        // TODO 5: 가장 매출이 높은 브랜드 (브랜드별 매출 합계 기준)
        BrandStats topBrand = findTopBrand(bodyHolic, merge);

        printReport(orders.size(), totalSales, averageSales, bodyHolic, merge, provinces, provinceCounts, topBrand);
    }

    private static int sumPrices(List<Order> orders) {
        int total = 0;
        for (Order order : orders) {
            total += order.getPrice();
        }
        return total;
    }

    private static double calculateAverage(int totalSales, int orderCount) {
        if (orderCount == 0) {
            return 0;
        }
        return (double) totalSales / orderCount;
    }

    private static BrandStats aggregateByBrand(List<Order> orders, String brand) {
        int count = 0;
        int total = 0;
        for (Order order : orders) {
            if (brand.equals(order.getBrand())) {
                count++;
                total += order.getPrice();
            }
        }
        return new BrandStats(brand, count, total);
    }

    private static BrandStats findTopBrand(BrandStats first, BrandStats second) {
        if (first.total >= second.total) {
            return first;
        }
        return second;
    }

    private static String extractProvince(Order order) {
        String region = order.getRegion();
        if (region == null || region.isBlank()) {
            return UNKNOWN_PROVINCE;
        }
        return region.split(" ")[0];
    }

    private static List<String> collectProvinces(List<Order> orders) {
        List<String> provinces = new ArrayList<>();
        for (Order order : orders) {
            String province = extractProvince(order);
            if (!provinces.contains(province)) {
                provinces.add(province);
            }
        }
        return provinces;
    }

    private static int[] countByProvinces(List<Order> orders, List<String> provinces) {
        int[] counts = new int[provinces.size()];
        for (Order order : orders) {
            String province = extractProvince(order);
            int index = provinces.indexOf(province);
            if (index >= 0) {
                counts[index]++;
            }
        }
        return counts;
    }

    private static String formatWon(int amount) {
        return String.format("%,d", amount) + "원";
    }

    private static String formatWon(double amount) {
        return String.format("%,.0f", amount) + "원";
    }

    private static void printBrandLine(BrandStats stats) {
        System.out.println(stats.brand + ": " + stats.count + "건 / " + formatWon(stats.total));
    }

    private static void printReport(
            int orderCount,
            int totalSales,
            double averageSales,
            BrandStats bodyHolic,
            BrandStats merge,
            List<String> provinces,
            int[] provinceCounts,
            BrandStats topBrand) {

        System.out.println("===== 매출 보고서 =====");
        System.out.println("전체 주문: " + orderCount + "건");
        System.out.println("전체 매출: " + formatWon(totalSales));
        System.out.println("평균 주문 금액: " + formatWon(averageSales));
        System.out.println();

        System.out.println("--- 브랜드별 ---");
        printBrandLine(bodyHolic);
        printBrandLine(merge);
        System.out.println();

        System.out.println("--- 지역별 주문 건수 ---");
        for (int i = 0; i < provinces.size(); i++) {
            System.out.println(provinces.get(i) + ": " + provinceCounts[i] + "건");
        }
        System.out.println();

        System.out.println("가장 매출이 높은 브랜드: " + topBrand.brand + " - " + formatWon(topBrand.total));
        System.out.println("========================");
    }

    private static class BrandStats {

        private final String brand;
        private final int count;
        private final int total;

        private BrandStats(String brand, int count, int total) {
            this.brand = brand;
            this.count = count;
            this.total = total;
        }
    }
}
