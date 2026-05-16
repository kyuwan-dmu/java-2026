package practice03;

import data.OrderDataProvider;
import model.Order;

public class Main {

    private static final String BRAND_BODY_HOLIC = "바디홀릭";
    private static final int PRICE_THRESHOLD = 15000;

    public static void main(String[] args) {
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        if (orders.length == 0) {
            System.out.println("주문 데이터가 없습니다. resources/orders.csv를 확인하세요.");
            return;
        }

        // TODO 1~3: 바디홀릭 주문 출력, 건수, 합계
        int bodyHolicCount = 0;
        int bodyHolicTotal = 0;

        System.out.println("===== 바디홀릭 주문 목록 =====");
        for (Order order : orders) {
            if (BRAND_BODY_HOLIC.equals(order.getBrand())) {
                System.out.println(order + " (" + order.getRegion() + ")");
                bodyHolicCount++;
                bodyHolicTotal += order.getPrice();
            }
        }
        System.out.println("============================");
        System.out.println("바디홀릭 주문: " + bodyHolicCount + "건");
        System.out.println("합계: " + formatWon(bodyHolicTotal));
        System.out.println();

        // TODO 4: 상품금액이 15,000원 이상인 주문만 출력
        System.out.println("===== 15,000원 이상 주문 =====");
        for (Order order : orders) {
            if (order.getPrice() >= PRICE_THRESHOLD) {
                System.out.println(order + " (" + order.getRegion() + ")");
            }
        }
        System.out.println("============================");
    }

    private static String formatWon(int price) {
        return String.format("%,d", price) + "원";
    }
}
