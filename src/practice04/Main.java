package practice04;

import data.OrderDataProvider;
import model.Order;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기 (리스트)
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: 현재 주문 건수 출력

        // TODO 2: 신규 주문 2건 추가 후 건수 출력

        // TODO 3: 첫 번째 주문 삭제 후 건수 출력

        // TODO 4: 전체 주문 리스트 출력

    }
}
