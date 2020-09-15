package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Task_04_Basic_Queue_Operations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();

        int[] inputData = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        readInputData(sc, inputData, deque);
        printData(inputData, deque);

    }

    private static void printData(int[] inputData, Deque<Integer> deque) {
        int numberToSearch = inputData[2];

        int smallestNumberInDeque = deque.stream().min(Integer::compareTo).orElse(0);

        String output = deque.contains(numberToSearch) ? "true" : String.valueOf(smallestNumberInDeque);

        System.out.println(output);

    }

    private static void readInputData(Scanner sc, int[] inputData, Deque<Integer> deque) {
        int limitElementsToPush = inputData[0];

        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).limit(limitElementsToPush).forEach(deque::offer);

        int elementsToPop = inputData[1];

        deque.stream().limit(elementsToPop).forEach(number -> deque.pop());

    }
}