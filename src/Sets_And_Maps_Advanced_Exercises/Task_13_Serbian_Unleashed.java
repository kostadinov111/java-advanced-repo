package Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_13_Serbian_Unleashed {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Long>> venueSingerMoney = new LinkedHashMap<>();

        readInput(sc, venueSingerMoney);
        printVenueSingerAndMoney(venueSingerMoney);

    }

    private static void printVenueSingerAndMoney(Map<String, Map<String, Long>> venueSingerMoney) {
        StringBuilder output = new StringBuilder();

        venueSingerMoney
                .forEach((key, value) -> {
                    output.append(String.format("%s%n", key));
                    value
                            .entrySet()
                            .stream()
                            .sorted((item1, item2) -> Long.compare(item2.getValue(), item1.getValue()))
                            .forEach(item -> output.append(String.format("#  %s -> %d%n", item.getKey(), item.getValue())));
                });

        System.out.println(output);

    }

    private static void readInput(Scanner sc, Map<String, Map<String, Long>> venueSingerMoney) {
        String input;
        String regex = "^(?<singer>([A-Za-z]+ ){1,3})@(?<venue>([A-Za-z]+ ){1,3})(?<ticketsPrice>[\\d]+) (?<ticketsCount>[\\d]+)$";

        Pattern pattern = Pattern.compile(regex);

        while (!"End".equals(input = sc.nextLine())) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String singer = matcher.group("singer").substring(0, matcher.group("singer").length() - 1);
                String venue = matcher.group("venue").substring(0, matcher.group("venue").length() - 1);
                long ticketsPrice = Long.parseLong(matcher.group("ticketsPrice"));
                long ticketsCount = Long.parseLong(matcher.group("ticketsCount"));
                long currentAmount = ticketsPrice * ticketsCount;
                venueSingerMoney.putIfAbsent(venue, new LinkedHashMap<>());
                venueSingerMoney.get(venue).putIfAbsent(singer, 0L);
                venueSingerMoney.get(venue).put(singer, venueSingerMoney.get(venue).get(singer) + currentAmount);
            }

        }
    }
}