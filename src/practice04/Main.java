package practice04;

import data.OrderDataProvider;
import model.Order;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기 (리스트)
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: 현재 주문 건수 출력
        System.out.println("현재 주문 건수: " + orders.size()+"건 \n");

        // TODO 2: 신규 주문 2건 추가 후 건수 출력
        orders.add(new Order("8888888", "테스트 상품1", "", 1, "머지", 17000, "2024-08-28 09:00:00", "301 배송 준비 중", "서울 강남구"));
        orders.add(new Order("9999999", "테스트 상품2", "", 2, "머지", 15000, "2024-08-28 09:10:00", "301 배송 준비 중", "서울 서초구"));

        System.out.println("[신규 주문 추가]");
        System.out.println("추가 후 건수: " + orders.size()+"건 \n");

        // TODO 3: 첫 번째 주문 삭제 후 건수 출력
        orders.remove(0);

        System.out.println("[첫 번째 주문 삭제]");
        System.out.println("삭제 후 건수: " + orders.size()+"건 \n");

        // TODO 4: 전체 주문 리스트 출력
        System.out.println("===== 전체 주문 =====");
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println("====================");
    }
}
