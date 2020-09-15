package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task_03_Maximum_Element {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<Integer> numbers = new ArrayDeque<>();

        readNumbersAndPrintResult(sc, numbers);

    }

    private static void readNumbersAndPrintResult(Scanner sc, Deque<Integer> numbers) {
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder output = new StringBuilder();

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String token = tokens[0];

            switch (token) {
                case "1": {
                    int number = Integer.parseInt(tokens[1]);
                    numbers.push(number);
                }
                break;
                case "2": {
                    numbers.pop();
                }
                break;
                case "3": {
                    printMaxNumberInStack(output, numbers);
                }
                break;
                default:
                    throw new IllegalStateException("Unknown value of tokens[0] -> " + tokens[0]);
            }
        }

        System.out.println(output);

    }

    private static void printMaxNumberInStack(StringBuilder output, Deque<Integer> numbers) {
        output.append(String.format("%d%n", numbers.stream().max(Integer::compareTo).orElse(0)));
    }

}