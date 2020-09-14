package Sets_And_Maps_Advanced_Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_12_Legendary_Farming {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();

        readInputTillItemIsObtained(sc, keyMaterials);

    }

    private static void readInputTillItemIsObtained(Scanner sc, Map<String, Integer> keyMaterials) {
        StringBuilder output = new StringBuilder();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        int quantityLimit = 250;
        boolean isItemObtained = false;

        while (keyMaterials.get("shards") < quantityLimit &&  keyMaterials.get("fragments") < quantityLimit && keyMaterials.get("motes") < quantityLimit) {

            String[] tokens = sc.nextLine().split("\\s+");

            for (int i = 1; i < tokens.length; i += 2) {
                if ("shards".equals(tokens[i].toLowerCase())) {
                    int currentQuantity = keyMaterials.get("shards") + Integer.parseInt(tokens[i - 1]);
                    keyMaterials.put("shards", currentQuantity);
                    if (currentQuantity >= quantityLimit) {
                        keyMaterials.put("shards", currentQuantity - quantityLimit);
                        isItemObtained = true;
                        output.append("Shadowmourne obtained!\n");
                        break;
                    }
                } else if ("fragments".equals(tokens[i].toLowerCase())) {
                    int currentQuantity = keyMaterials.get("fragments") + Integer.parseInt(tokens[i - 1]);
                    keyMaterials.put("fragments", currentQuantity);
                    if (currentQuantity >= quantityLimit) {
                        keyMaterials.put("fragments", currentQuantity - quantityLimit);
                        isItemObtained = true;
                        output.append("Valanyr obtained!\n");
                        break;
                    }
                } else if ("motes".equals(tokens[i].toLowerCase())) {
                    int currentQuantity = keyMaterials.get("motes") + Integer.parseInt(tokens[i - 1]);
                    keyMaterials.put("motes", currentQuantity);
                    if (currentQuantity >= quantityLimit) {
                        keyMaterials.put("motes", currentQuantity - quantityLimit);
                        isItemObtained = true;
                        output.append("Dragonwrath obtained!\n");
                        break;
                    }
                } else {
                    keyMaterials.putIfAbsent(tokens[i].toLowerCase(), 0);
                    keyMaterials.put(tokens[i].toLowerCase(), keyMaterials.get(tokens[i].toLowerCase()) + Integer.parseInt(tokens[i - 1]));
                }

            }

            if (isItemObtained) {
                break;
            }

        }

        keyMaterials
                .entrySet()
                .stream()
                .filter(item -> "shards".equals(item.getKey()) || "fragments".equals(item.getKey()) || "motes".equals(item.getKey()))
                .sorted((item1, item2) -> Integer.compare(item2.getValue(), item1.getValue()))
                .forEach(item -> output.append(String.format("%s: %d%n", item.getKey(), item.getValue())));

        keyMaterials
                .entrySet()
                .stream()
                .filter(item -> !("shards".equals(item.getKey()) || "fragments".equals(item.getKey()) || "motes".equals(item.getKey())))
                .forEach(item -> output.append(String.format("%s: %d%n", item.getKey(), item.getValue())));

        System.out.println(output);

    }
}