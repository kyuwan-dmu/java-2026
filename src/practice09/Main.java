package practice09;

import data.OrderDataProvider;
import model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // 데이터 불러오기
    List<Order> orders = OrderDataProvider.getOrdersAsList();

    // 사은품 대상 주문을 담을 ArrayList
    ArrayList<Order> giftOrders = new ArrayList<>();

    // 사은품 배송이 필요한 지역을 저장할 HashSet (중복 자동 제거)
    HashSet<String> regions = new HashSet<>();

    for (Order order : orders) {
      regions.add(order.getRegion());
      if (order.getPrice() >= 10000) {
        giftOrders.add(order);
      }
    }

    print(giftOrders, orders, regions);
  }

  private static void print(ArrayList<Order> giftOrders, List<Order> orders,
      HashSet<String> regions) {
    System.out.println("===== 사은품 지급 이벤트 처리 =====");
    System.out.println("[대상 주문 수] " + giftOrders.size() + "건 / 전체 " + orders.size() + "건");
    System.out.println("\n[사은품별 건수]");
    System.out.println(
        "미니 향수 세트: " + giftOrders.stream().filter(data -> "미니 향수 세트".equals(data.getGift()))
            .count() + "건");
    System.out.println(
        "샘플 키트: " + giftOrders.stream().filter(data -> "샘플 키트".equals(data.getGift())).count()
            + "건");
    System.out.println("\n[대상 주문 목록]");
    for(Order giftOrder : giftOrders){
      System.out.println(giftOrder.toString());
    }
    System.out.println("\n[사은품 배송 지역 (중복 제거)]");
    for(String region : regions){
      System.out.print(region+" ");
    }
  }
}
