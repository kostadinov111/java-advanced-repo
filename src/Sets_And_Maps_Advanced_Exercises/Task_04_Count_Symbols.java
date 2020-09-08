package Sets_And_Maps_Advanced_Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_04_Count_Symbols {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Character, Integer> countSymbols = new TreeMap<>();

        readInput(sc, countSymbols);
        printCountSymbols(countSymbols);

    }

    private static void printCountSymbols(Map<Character, Integer> countSymbols) {
        countSymbols
                .forEach((key, value) -> {
                    System.out.println(String.format("%c: %d time/s", key, value));
                });
    }

    private static void readInput(Scanner sc, Map<Character, Integer> countSymbols) {
        char[] symbols = sc.nextLine().toCharArray();

        for (char symbol : symbols) {
            countSymbols.putIfAbsent(symbol, 0);
            countSymbols.put(symbol, countSymbols.get(symbol) + 1);
        }

    }
}