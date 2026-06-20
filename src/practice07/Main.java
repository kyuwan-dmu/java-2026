package practice07;

import data.OrderDataProvider;
import model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = OrderDataProvider.getOrdersAsList();

        Map<String, Integer> brandCount = new HashMap<>();
        for (Order o : orders) {
            String brand = o.getBrand();
            brandCount.put(brand, brandCount.getOrDefault(brand, 0) + 1);
        }

        Map<String, Integer> brandTotal = new HashMap<>();
        for (Order o : orders) {
            String brand = o.getBrand();
            brandTotal.put(brand, brandTotal.getOrDefault(brand, 0) + o.getPrice());
        }

        Map<String, Integer> regionCount = new HashMap<>();
        for (Order o : orders) {
            String region = o.getRegion().split(" ")[0];
            regionCount.put(region, regionCount.getOrDefault(region, 0) + 1);
        }

        System.out.println("===== 브랜드별 주문 건수 =====");
        for (Map.Entry<String, Integer> entry : brandCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "건");
        }

        System.out.println();
        System.out.println("===== 브랜드별 매출 =====");
        for (Map.Entry<String, Integer> entry : brandTotal.entrySet()) {
            System.out.printf("%s: %,d원%n", entry.getKey(), entry.getValue());
        }

        System.out.println();
        System.out.println("===== 지역별 주문 건수 =====");
        List<Map.Entry<String, Integer>> regionList = new ArrayList<>(regionCount.entrySet());
        Collections.sort(regionList, (a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> entry : regionList) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "건");
        }

        System.out.println();
        System.out.println("===== 인기 상품 TOP 3 =====");
        Map<String, Integer> productCount = new HashMap<>();
        for (Order o : orders) {
            String product = o.getProductName();
            productCount.put(product, productCount.getOrDefault(product, 0) + 1);
        }
        List<Map.Entry<String, Integer>> productList = new ArrayList<>(productCount.entrySet());
        Collections.sort(productList, (a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < 3 && i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i).getKey() + ": " + productList.get(i).getValue() + "건");
        }
    }
}
