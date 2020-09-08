package Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_06_A_Miner_Task {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Long> resourceQuantity = new LinkedHashMap<>();

        readResourceAndQuantity(sc, resourceQuantity);
        printResourceAndQuantity(resourceQuantity);

    }

    private static void printResourceAndQuantity(Map<String, Long> resourceQuantity) {
        resourceQuantity
                .forEach((key, value) -> {
                    System.out.println(String.format("%s -> %d", key, value));
                });
    }

    private static void readResourceAndQuantity(Scanner sc, Map<String, Long> resourceQuantity) {
        String resource;

        while (!"stop".equals(resource = sc.nextLine())) {
            Long quantity = Long.parseLong(sc.nextLine());
            resourceQuantity.putIfAbsent(resource, 0L);
            resourceQuantity.put(resource, resourceQuantity.get(resource) + quantity);
        }

    }
}