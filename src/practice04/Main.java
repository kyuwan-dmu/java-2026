package practice04;

import data.OrderDataProvider;
import model.Order;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기 (리스트)
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: 현재 주문 건수 출력
        System.out.printf("현재 주문 건수: %d건\n", orders.size());

        // TODO 2: 신규 주문 2건 추가 후 건수 출력
        System.out.println("[신규 주문 추가]");
        orders.add(
                new Order(
                    "2596171645",
                    "\"[단독]\"\"니치 향\"\" 바디홀릭 스테이누디 디스커버리 세트 (20ml*6종)\"",
                    "",
                    1,
                    "바디홀릭",
                    20000,
                    "2024-08-27 16:53:41",
                    "301 배송 준비 중",
                    "경기 안산시"
                )
        );
        orders.add(
                new Order(
                        "2596171645",
                        "\"[단독]\"\"니치 향\"\" 바디홀릭 스테이누디 디스커버리 세트 (20ml*6종)\"",
                        "",
                        1,
                        "바디홀릭",
                        20000,
                        "2024-08-27 16:53:41",
                        "301 배송 준비 중",
                        "경기 안산시"
                )
        );
        System.out.printf("추가 후 건수: %d건\n", orders.size());

        // TODO 3: 첫 번째 주문 삭제 후 건수 출력

        System.out.println("[첫 번째 주문 삭제]");
        orders.remove(0);

        System.out.printf("삭제 후 건수: %d건\n", orders.size());


        // TODO 4: 전체 주문 리스트 출력
    }
}
