package Sets_And_Maps_Advanced_Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_11_Logs_Aggregator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Integer>> logsAggregator = new TreeMap<>();

        readLogs(sc, logsAggregator);
        printLogs(logsAggregator);

    }

    private static void printLogs(Map<String, Map<String, Integer>> logsAggregator) {
        StringBuilder output = new StringBuilder();

        logsAggregator
                .forEach((key, value) -> {
                    int sumDuration = value
                            .values()
                            .stream()
                            .mapToInt(Integer::intValue)
                            .sum();

                    output.append(String.format("%s: %d [", key, sumDuration));

                    value
                            .keySet()
                            .forEach(k ->  output.append(String.format("%s, ", k)));

                    int lastAddedCommaAndSpace = output.length();
                    output.replace(lastAddedCommaAndSpace - 2, lastAddedCommaAndSpace, "]").append("\n");
                });

        System.out.println(output);
    }

    private static void readLogs(Scanner sc, Map<String, Map<String, Integer>> logsAggregator) {
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            logsAggregator.putIfAbsent(user, new TreeMap<>());
            logsAggregator.get(user).putIfAbsent(ip, 0);
            logsAggregator.get(user).put(ip, (logsAggregator.get(user).get(ip) + duration));
        }

    }
}