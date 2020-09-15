package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Task_01_Reverse_Numbers_With_A_Stack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        readNumbers(sc, stack);
        printNumbers(stack);

    }

    private static void printNumbers(Deque<Integer> stack) {
        StringBuilder output = new StringBuilder();

        stack
                .forEach(number -> output.append(String.format("%d ", stack.pop())));

        System.out.println(output.toString().trim());
    }

    private static void readNumbers(Scanner sc, Deque<Integer> stack) {
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int number : numbers) {
            stack.push(number);
        }
    }
}