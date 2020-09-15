package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class Task_14_Dragon_Army {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, List<Double>>> dragonsStat = new LinkedHashMap<>();

        readDragonStatInput(sc, dragonsStat);
        printDragonStat(dragonsStat);

    }

    private static void printDragonStat(Map<String, Map<String, List<Double>>> dragonsStat) {
        StringBuilder output = new StringBuilder();

        dragonsStat
                .forEach((type, dragons) -> {
                    double damageAvg = dragons
                            .values()
                            .stream()
                            .mapToDouble(item -> item.get(0))
                            .average()
                            .orElse(0.00d);
                    double healthAvg = dragons
                            .values()
                            .stream()
                            .mapToDouble(item -> item.get(1))
                            .average()
                            .orElse(0.00d);
                    double armorAvg = dragons
                            .values()
                            .stream()
                            .mapToDouble(item -> item.get(2))
                            .average()
                            .orElse(0.00d);

                    output.append(String.format("%s::(%.2f/%.2f/%.2f)%n", type, damageAvg, healthAvg, armorAvg));

                    dragons
                            .forEach((name, stat) -> output.append(String.format("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", name, stat.get(0), stat.get(1), stat.get(2))));
                });

        System.out.println(output);

    }

    private static void readDragonStatInput(Scanner sc, Map<String, Map<String, List<Double>>> dragonsStat) {
        int n = Integer.parseInt(sc.nextLine());
        double healthDefaultValue = 250.00d;
        double damageDefaultValue = 45.00d;
        double armorDefaultValue = 10.00d;

        while (n-- > 0) {

            String[] tokens = sc.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double  damage = (!"null".equals(tokens[2])) ? Double.parseDouble(tokens[2]) : damageDefaultValue;
            double  health = (!"null".equals(tokens[3])) ? Double.parseDouble(tokens[3]) : healthDefaultValue;
            double  armor = (!"null".equals(tokens[4])) ? Double.parseDouble(tokens[4]) : armorDefaultValue;

            dragonsStat.putIfAbsent(type, new TreeMap<>());
            dragonsStat.get(type).putIfAbsent(name, new ArrayList<>());
            dragonsStat.get(type).get(name).clear();
            dragonsStat.get(type).get(name).add(damage);
            dragonsStat.get(type).get(name).add(health);
            dragonsStat.get(type).get(name).add(armor);

        }

    }
}