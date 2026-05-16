package practice01;

import data.OrderDataProvider;
import java.text.NumberFormat;
import java.util.Locale;
import model.Order;

public class Main {

    public static void main(String[] args) {
        // 데이터 불러오기
        Order[] orders = OrderDataProvider.getOrdersAsArray();

        System.out.println("===== 주문 상세 =====");
        System.out.println("주문번호: " + orders[0].getOrderId());
        System.out.println("상품명: " + orders[0].getProductName());
        System.out.println("브랜드: " + orders[0].getBrand());
        if(orders[0].getOption().isEmpty()) {
            System.out.println("옵션: (없음)");
        } else System.out.println("옵션: " + orders[0].getOption());
        System.out.println("수량: " + orders[0].getQuantity());
        System.out.println("금액: " + NumberFormat.getNumberInstance(Locale.KOREA).format(orders[0].getPrice()) + "원");
        System.out.println("주문일: " + orders[0].getOrderDate());
        System.out.println("상태: " + orders[0].getStatus());
        System.out.println("지역: " + orders[0].getRegion());
        System.out.println("====================\n");
    }
}
