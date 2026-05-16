package practice04;

import data.OrderDataProvider;
import model.Order;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기 (리스트)
        ArrayList<Order> orders = new ArrayList<>(OrderDataProvider.getOrdersAsList());


        // TODO 1: 현재 주문 건수 출력
        System.out.println("현재 주문 건수: " + orders.size() + "건");
        System.out.println("---------------------------------------------");


        // TODO 2: 신규 주문 2건 추가 후 건수 출력
        // [수정 포인트] 생성자(new Order)를 호출하여 객체를 리스트에 추가해야 합니다.
        System.out.println("[신규 주문 추가]");
        orders.add(new Order("9999999", "테스트 상품 1", "", 1, "머지", 15000, "2024-08-28 09:00:00", "301 배송 준비 중", "서울 강남구"));
        orders.add(new Order("8888888", "테스트 상품 2", "", 2, "카카오", 25000, "2024-08-28 09:30:00", "301 배송 준비 중", "서울 서초구"));

        System.out.println("신규 주문 2건 추가 후 건수: " + orders.size() + "건");
        System.out.println("---------------------------------------------");

        // TODO 3: 첫 번째 주문 삭제 후 건수 출력
        System.out.println("[첫 번째 주문 삭제]");
        orders.remove(75);
        // TODO 4: 전체 주문 리스트 출력
        System.out.println("===== 전체 주문 목록 =====");
        for(int i = 0; i < orders.size(); i++){

            System.out.println(". " + orders.get(i).getProductName() + " - "+String.format("%,d",orders.get(i).getPrice()));
        }
        System.out.println("========================");
    }
}