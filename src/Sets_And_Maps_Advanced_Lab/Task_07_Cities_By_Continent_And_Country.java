package Sets_And_Maps_Advanced_Lab;

import java.util.*;

public class Task_07_Cities_By_Continent_And_Country {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, List<String>>> mapCities = new LinkedHashMap<>();

        readCites(sc, mapCities);
        printCities(mapCities);

    }

    private static void printCities(Map<String, Map<String, List<String>>> mapCities) {
        mapCities
                .forEach((key, value) -> {
                    System.out.println(String.format("%s:", key));
                    value
                            .forEach((k, v) -> {
                                System.out.print(String.format("%s -> ", k));
                                System.out.println(String.join(", ", v));
                            });
                });
    }

    private static void readCites(Scanner sc, Map<String, Map<String, List<String>>> mapCities) {
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            mapCities.putIfAbsent(continent, new LinkedHashMap<>());
            mapCities.get(continent).putIfAbsent(country, new ArrayList<>());
            mapCities.get(continent).get(country).add(city);
        }

    }
}