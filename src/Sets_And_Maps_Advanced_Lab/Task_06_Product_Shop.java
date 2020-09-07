package Sets_And_Maps_Advanced_Lab;

import java.util.*;

public class Task_06_Product_Shop {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Double>> productShop = new TreeMap<>();

        readInfoAboutFoodShops(sc, productShop);
        printFoodShops(productShop);

    }

    private static void printFoodShops(Map<String, Map<String, Double>> productShop) {
        productShop
                .forEach((key, value) -> {
                    System.out.println(String.format("%s->", key));
                    value
                            .forEach((k, v) -> System.out.println(String.format("Product: %s, Price: %.1f", k, v)));
                });
    }

    private static void readInfoAboutFoodShops(Scanner sc, Map<String, Map<String, Double>> mapProductShop) {
        String input;

        while (!"Revision".equals(input = sc.nextLine())) {
            String[] tokens = input.split(",\\s+");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            mapProductShop.putIfAbsent(shop, new LinkedHashMap<>());
            mapProductShop.get(shop).put(product, price);

        }

    }
}