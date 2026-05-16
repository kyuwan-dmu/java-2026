package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Order;

/**
 * 주문 데이터를 불러오는 클래스입니다.
 * 학생들은 이 클래스를 수정할 필요 없이, 아래 메서드를 호출하여 데이터를 받아 사용합니다.
 *
 * 사용법:
 *   Order[] orders = OrderDataProvider.getOrdersAsArray();
 *   List<Order> orderList = OrderDataProvider.getOrdersAsList();
 */
public class OrderDataProvider {

    private static final String CSV_PATH = "resources/orders.csv";

    /**
     * 주문 데이터를 Order 배열로 반환합니다.
     */
    public static Order[] getOrdersAsArray() {
        List<Order> list = loadOrders();
        return list.toArray(new Order[0]);
    }

    /**
     * 주문 데이터를 List<Order>로 반환합니다.
     */
    public static List<Order> getOrdersAsList() {
        return loadOrders();
    }

    private static List<Order> loadOrders() {
        List<Order> orders = new ArrayList<>();
        Path path = Paths.get(CSV_PATH);

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = br.readLine(); // 헤더 스킵

            while ((line = br.readLine()) != null) {
                Order order = parseLine(line);
                if (order != null) {
                    orders.add(order);
                }
            }
        } catch (IOException e) {
            System.out.println("데이터 파일을 읽을 수 없습니다: " + e.getMessage());
            System.out.println("프로젝트 루트에 resources/orders.csv 파일이 있는지 확인하세요.");
        }

        return orders;
    }

    private static Order parseLine(String line) {
        String[] tokens = splitCsvLine(line);
        if (tokens.length < 9) return null;

        try {
            String orderId = tokens[0].trim();
            String productName = tokens[1].trim();
            String option = tokens[2].trim();
            int quantity = Integer.parseInt(tokens[3].trim());
            String brand = tokens[4].trim();
            int price = Integer.parseInt(tokens[5].trim());
            String orderDate = tokens[6].trim();
            String status = tokens[7].trim();
            String region = tokens[8].trim();

            return new Order(orderId, productName, option, quantity, brand, price, orderDate, status, region);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static String[] splitCsvLine(String line) {
        List<String> tokens = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                tokens.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        tokens.add(sb.toString());

        return tokens.toArray(new String[0]);
    }
}
