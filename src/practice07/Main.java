package practice07;

import data.OrderDataProvider;
import model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: 브랜드별 주문 ��수를 Map으로 집계하시오

        // TODO 2: 브랜드별 매출 합계를 Map으로 집계하시오

        // TODO 3: 지역별 주문 건수를 Map으로 집계하시오

        // TODO 4: 각 Map의 내용을 출력하시오

        // TODO 5: (추가) 상품명별 주문 건수 상위 3개를 출력하시오

    }
}
