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

        // 주문번호 → 사은품 이름을 저장할 HashMap
        HashMap<String, String> giftMap = new HashMap<>();

        // 사은품 배송이 필요한 지역을 저장할 HashSet (중복 자동 제거)
        HashSet<String> regions = new HashSet<>();

        // TODO 1: for문으로 전체 주문을 순회하면서 사은품 대상을 처리하시오
        //   - 20,000원 이상 → giftOrders에 추가, giftMap에 "미니 향수 세트" 저장, regions에 지역 추가
        //   - 10,000원 이상 ~ 20,000원 미만 → giftOrders에 추가, giftMap에 "샘플 키트" 저장, regions에 지역 추가
        //   - 10,000원 미만 → 아무 처리 안 함


        // TODO 2: 대상 주문 수 출력 (예: "[대상 주문 수] 66건 / 전체 74건")


        // TODO 3: 사은품 종류별 건수 출력
        //   힌트: giftMap의 value들을 순회하면서 "미니 향수 세트" 개수와 "샘플 키트" 개수를 세기


        // TODO 4: 대상 주문 목록 출력
        //   힌트: giftOrders를 순회하면서 giftMap.get(order.getOrderId())로 사은품 이름을 꺼내기


        // TODO 5: 사은품 배송 지역 목록 출력 (중복 없이)
        //   힌트: regions를 순회하면서 출력, regions.size()로 총 지역 수 출력

    }
}
