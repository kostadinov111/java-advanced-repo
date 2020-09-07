package Sets_And_Maps_Advanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_04_Count_Real_Numbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Double, Integer> mapCountRealNumbers = new LinkedHashMap<>();

        readRealNumbers(sc, mapCountRealNumbers);
        printRealNumbers(mapCountRealNumbers);

    }

    private static void printRealNumbers(Map<Double, Integer> mapCountRealNumbers) {
        mapCountRealNumbers
                .forEach((key, value) -> System.out.println(String.format("%.1f -> %d", key, value)));
    }

    private static void readRealNumbers(Scanner sc, Map<Double, Integer> mapCountRealNumbers) {
        double[] realNumbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        for (double realNumber : realNumbers) {
            mapCountRealNumbers.putIfAbsent(realNumber, 0);
            mapCountRealNumbers.put(realNumber, mapCountRealNumbers.get(realNumber) + 1);
        }
    }
}