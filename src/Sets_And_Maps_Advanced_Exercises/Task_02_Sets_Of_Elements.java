package Sets_And_Maps_Advanced_Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Task_02_Sets_Of_Elements {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        readSets(sc, firstSet, secondSet);
        printNonRepeatingElements(firstSet, secondSet);

    }

    private static void printNonRepeatingElements(Set<String> firstSet, Set<String> secondSet) {
        StringBuilder output = new StringBuilder();

        if (firstSet.size() < secondSet.size()) {

            for (String element : firstSet) {
                if (secondSet.contains(element)) output.append(element).append(" ");
            }

        } else {

            for (String element : secondSet) {
                if (firstSet.contains(element)) output.append(element).append(" ");
            }
        }

        System.out.println(output.toString().trim());
    }

    private static void readSets(Scanner sc, Set<String> firstSet, Set<String> secondSet) {
        int[] tokens = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstN = tokens[0];
        int secondN = tokens[1];

        for (int i = 0; i < firstN; i++) {
            String element = sc.nextLine();
            firstSet.add(element);
        }

        for (int i = 0; i < secondN; i++) {
            String element = sc.nextLine();
            secondSet.add(element);
        }

    }
}