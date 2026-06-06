package practice06;

import data.OrderDataProvider;
import model.Order;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: 주문일 오름차순으로 정렬하여 출력하시오

        // TODO 2: 상품금액 내림차순으로 정렬하여 출력하시오

        // TODO 3: 브랜드별 오름차순 → 같은 브랜드 내 금액 내림차순 정렬하시오

        // TODO 4: (추가) 정렬 후 상위 5건만 출력하시오

    }
}
