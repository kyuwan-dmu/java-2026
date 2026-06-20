package practice05;

import data.OrderDataProvider;
import model.Order;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        int totalPrice = 0;
        for (Order o : orders) {
            totalPrice += o.getPrice();
        }

        System.out.println("===== 매출 보고서 =====");
        System.out.println("전체 주문: " + orders.size() + "건");
        System.out.println("전체 매출: " + String.format("%,d", totalPrice) + "원");
        System.out.printf("평균 주문 금액: %,d원%n", (int)((double) totalPrice / orders.size()));

        System.out.println();
        System.out.println("--- 브랜드별 ---");
        int bodyHolicCount = 0, bodyHolicTotal = 0;
        int mergeCount = 0, mergeTotal = 0;
        for (Order o : orders) {
            if (o.getBrand().equals("바디홀릭")) {
                bodyHolicCount++;
                bodyHolicTotal += o.getPrice();
            } else {
                mergeCount++;
                mergeTotal += o.getPrice();
            }
        }
        System.out.printf("바디홀릭: %d건 / %,d원%n", bodyHolicCount, bodyHolicTotal);
        System.out.printf("머지: %d건 / %,d원%n", mergeCount, mergeTotal);

        System.out.println();
        System.out.println("--- 지역별 주문 건수 ---");
        String[] regions = {"경기", "서울", "부산", "경북", "인천", "대구", "광주", "대전", "울산", "강원", "충북", "충남", "전북", "전남", "경남", "제주"};
        for (String region : regions) {
            int cnt = 0;
            for (Order o : orders) {
                if (o.getRegion().startsWith(region)) {
                    cnt++;
                }
            }
            if (cnt > 0) {
                System.out.println(region + ": " + cnt + "건");
            }
        }

        System.out.println("========================");

        System.out.println();
        String topBrand = bodyHolicTotal >= mergeTotal ? "바디홀릭" : "머지";
        int topTotal = bodyHolicTotal >= mergeTotal ? bodyHolicTotal : mergeTotal;
        System.out.println("가장 매출이 높은 브랜드: " + topBrand + " (" + String.format("%,d", topTotal) + "원)");
    }
}
