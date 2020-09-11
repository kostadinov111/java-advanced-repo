package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class Task_10_Population_Counter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Long>> populationCounter = new LinkedHashMap<>();

        readData(sc, populationCounter);
        printDataReport(populationCounter);

    }

    private static void printDataReport(Map<String, Map<String, Long>> populationCounter) {
        StringBuilder output = new StringBuilder();

        populationCounter
                .entrySet()
                .stream()
                .sorted((c1, c2) -> Long.compare(c2.getValue().values().stream().mapToLong(Long::longValue).sum(), c1.getValue().values().stream().mapToLong(Long::longValue).sum()))
                .forEach(country -> {
                    long sum = country.getValue().values().stream().mapToLong(Long::longValue).sum();
                    output.append(String.format("%s (total population: %d)", country.getKey(), sum)).append("\n");
                    country.getValue().entrySet().stream().sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                            .forEach(city -> {
                                output.append(String.format("=>%s: %d", city.getKey(), city.getValue())).append("\n");
                            });
                });

        System.out.println(output);
    }

    private static void readData(Scanner sc, Map<String, Map<String, Long>> populationCounter) {
        String input;

        while (!"report".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);
            populationCounter.putIfAbsent(country, new LinkedHashMap<>());
            populationCounter.get(country).put(city, population);
        }

    }
}