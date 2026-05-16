package practice04;

import data.OrderDataProvider;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기 (리스트)
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: 현재 주문 건수 출력
        System.out.println("현재 주문 건수: " + orders.size() + "건\n");

        // TODO 2: 신규 주문 2건 추가 후 건수 출력
        long maxOrderId = 0;
        for (Order order : orders) {
            long id = Long.parseLong(order.getOrderId());
            if (id > maxOrderId) {
                maxOrderId = id;
            }
        }

        String newOrderId1 = String.valueOf(maxOrderId + 1);
        String newOrderId2 = String.valueOf(maxOrderId + 2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderDate = sdf.format(new Date());

        Order newOrder1 = new Order(
                newOrderId1, "테스트 상품", "", 1, "머지", 15000,
                orderDate, "301 배송 준비 중", "서울 강남구");
        Order newOrder2 = new Order(
                newOrderId2, "테스트 상품", "", 1, "머지", 15000,
                orderDate, "301 배송 준비 중", "서울 강남구");
        orders.add(newOrder1);
        orders.add(newOrder2);
        System.out.println("[신규 주문 추가]");
        System.out.println("추가 후 건수: " + orders.size() + "건\n");

        // TODO 3: 첫 번째 주문 삭제 후 건수 출력
        orders.remove(0);
        System.out.println("[첫 번째 주문 삭제]");
        System.out.println("삭제 후 건수: " + orders.size() + "건\n");

        // TODO 4: 전체 주문 리스트 출력
        System.out.println("===== 전체 주문 =====");
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println("====================");
    }
}
