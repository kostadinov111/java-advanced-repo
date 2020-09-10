package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class Task_09_User_Logs {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();

        readUserLogs(sc, userLogs);
        printUserLogs(userLogs);

    }

    private static void printUserLogs(Map<String, Map<String, Integer>> userLogs) {
        StringBuilder output = new StringBuilder();

        userLogs
                .forEach((key, value) -> {
                    output.append(key).append(":\n");
                    value
                            .forEach((k, v) -> {
                                output.append(k).append(" => ").append(v).append(", ");
                            });
                    output.replace(output.length() - 2, output.length(), ".\n");
                });

        System.out.println(output);
    }

    private static void readUserLogs(Scanner sc, Map<String, Map<String, Integer>> userLogs) {
        String input;

        while (!"end".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].substring(3);
            String user = tokens[2].substring(5);
            userLogs.putIfAbsent(user, new LinkedHashMap<>());
            userLogs.get(user).putIfAbsent(ip, 0);
            userLogs.get(user).put(ip, userLogs.get(user).get(ip) + 1);
        }

    }
}