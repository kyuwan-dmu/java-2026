package practice05;

import data.OrderDataProvider;
import model.Order;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        // TODO 1: 전체 매출(상품금액 합계)을 구하시오

        // TODO 2: 전체 평균 주문 금액을 구하시오

        // TODO 3: 브랜드별 주문 건수와 매출 합계를 구하시오

        // TODO 4: 지역별 주문 건수를 구하시오

        // TODO 5: (추가) 가장 매출이 높은 브랜드를 찾아 출력하시오

    }
}
