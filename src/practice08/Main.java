package practice08;

import data.OrderDataProvider;
import model.Order;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: Stream으로 바디홀릭 주문만 필터링하여 출력하시오

        // TODO 2: Stream으로 전체 매출 합계를 구하시오

        // TODO 3: Stream으로 상품금액 내림차순 상위 5건을 출력하시오

        // TODO 4: Stream으로 브랜드별 주문 건수를 집계하시오

        // TODO 5: (추가) Stream으로 브랜드별 매출 합계를 구하시오

    }
}
