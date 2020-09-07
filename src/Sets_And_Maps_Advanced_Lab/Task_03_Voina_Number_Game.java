package Sets_And_Maps_Advanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Task_03_Voina_Number_Game {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Integer> deckPlayer1 = new LinkedHashSet<>();
        Set<Integer> deckPlayer2 = new LinkedHashSet<>();

        readDeck(sc, deckPlayer1);
        readDeck(sc, deckPlayer2);

        String output = battleWithDecks(deckPlayer1, deckPlayer2);
        System.out.println(output);


    }

    private static String battleWithDecks(Set<Integer> deckPlayer1, Set<Integer> deckPlayer2) {
        int rounds = 50;
        boolean firstPlayerWin = false;
        boolean secondPlayerWin = false;
        boolean draw = false;

        while (rounds > 0 && !deckPlayer1.isEmpty() && !deckPlayer2.isEmpty()) {
            rounds--;

            int topNumberDeckPlayer1 = deckPlayer1.iterator().next();
            deckPlayer1.remove(topNumberDeckPlayer1);
            int topNumberDeckPlayer2 = deckPlayer2.iterator().next();
            deckPlayer2.remove(topNumberDeckPlayer2);

            if (topNumberDeckPlayer1 > topNumberDeckPlayer2) {
                deckPlayer1.add(topNumberDeckPlayer1);
                deckPlayer1.add(topNumberDeckPlayer2);
            } else if (topNumberDeckPlayer1 < topNumberDeckPlayer2) {
                deckPlayer2.add(topNumberDeckPlayer1);
                deckPlayer2.add(topNumberDeckPlayer2);
            }

            if (deckPlayer1.isEmpty() && deckPlayer2.isEmpty()) {
                draw = true;
                break;
            } else if (deckPlayer1.isEmpty()) {
                secondPlayerWin = true;
                break;
            } else if (deckPlayer2.isEmpty()) {
                firstPlayerWin = true;
                break;
            }


        }

        if (draw) {
            return "Draw!";
        } else if (firstPlayerWin) {
            return "First player win!";
        } else if (secondPlayerWin) {
            return "Second player win!";
        } else {
            return deckPlayer1.size() > deckPlayer2.size() ? "First player win!" : deckPlayer2.size() > deckPlayer1.size() ? "Second player win!" : "Draw!";
        }

    }

    private static void readDeck(Scanner sc, Set<Integer> deckPlayer) {
        int[] deck = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int card : deck) {
            deckPlayer.add(card);
        }
    }
}