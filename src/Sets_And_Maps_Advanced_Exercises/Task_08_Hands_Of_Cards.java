package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class Task_08_Hands_Of_Cards {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> cardsAndTypesValues = new HashMap<>();
        cardsAndTypesValues.put("J", 11);
        cardsAndTypesValues.put("Q", 12);
        cardsAndTypesValues.put("K", 13);
        cardsAndTypesValues.put("A", 14);
        cardsAndTypesValues.put("S", 4);
        cardsAndTypesValues.put("H", 3);
        cardsAndTypesValues.put("D", 2);
        cardsAndTypesValues.put("C", 1);
        cardsAndTypesValues.put("2", 2);
        cardsAndTypesValues.put("3", 3);
        cardsAndTypesValues.put("4", 4);
        cardsAndTypesValues.put("5", 5);
        cardsAndTypesValues.put("6", 6);
        cardsAndTypesValues.put("7", 7);
        cardsAndTypesValues.put("8", 8);
        cardsAndTypesValues.put("9", 9);
        cardsAndTypesValues.put("10", 10);

        Map<String, Set<String>> playersHandsOfCards = new LinkedHashMap<>();

        readPlayersHandsOfCards(sc, playersHandsOfCards);
        printPlayersHandsOfCards(playersHandsOfCards, cardsAndTypesValues);

    }

    private static void printPlayersHandsOfCards(Map<String, Set<String>> playersHandsOfCards, Map<String, Integer> cardsAndTypesValues) {
        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, Set<String>> entry : playersHandsOfCards.entrySet()) {
            output.append(entry.getKey()).append(": ");
            int points = 0;

            for (String card : playersHandsOfCards.get(entry.getKey())) {
                int powerOrType = 0;
                int firstSymbol = getCardValue(card, cardsAndTypesValues, powerOrType);
                int secondSymbol = getCardValue(card, cardsAndTypesValues, ++powerOrType);
                points += (firstSymbol * secondSymbol);
            }
            output.append(points).append("\n");

        }

        System.out.println(output);
    }

    private static int getCardValue(String card, Map<String, Integer> cardsAndTypesValues, int powerOrType) {

        if (card.length() == 2 && powerOrType == 0) {
            String symbol = "" + card.charAt(0);
            return cardsAndTypesValues.get(symbol);
        } else if (card.length() == 2 && powerOrType == 1) {
            String symbol = "" + card.charAt(1);
            return cardsAndTypesValues.get(symbol);
        } else if (card.length() == 3 && powerOrType == 0) {
            return cardsAndTypesValues.get("10");
        } else if (card.length() == 3 && powerOrType == 1) {
            String symbol = "" + card.charAt(2);
            return cardsAndTypesValues.get(symbol);
        }

        return 0;
    }

    private static void readPlayersHandsOfCards(Scanner sc, Map<String, Set<String>> playersHandsOfCards) {
        String input;

        while (!"JOKER".equals(input = sc.nextLine())) {
            String[] tokens = input.split(":");
            String name = tokens[0];
            String cardsFromDraw = tokens[1].trim();
            String[] cards = cardsFromDraw.split(",\\s+");

            playersHandsOfCards.putIfAbsent(name, new LinkedHashSet<>());
            playersHandsOfCards.get(name).addAll(Arrays.asList(cards));

        }

    }
}