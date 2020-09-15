package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Task_02_Basic_Stack_Operations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<Integer> numbers = new ArrayDeque<>();

        int[] inputData = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        readInputData(sc, inputData, numbers);
        printData(inputData, numbers);


    }

    private static void printData(int[] inputData, Deque<Integer> numbers) {
        int limitNumbersToPop = inputData[1];
        int numberToSearch = inputData[2];

        numbers.stream().limit(limitNumbersToPop).forEach(number -> numbers.pop());

        int smallestNumber = numbers.stream().min(Integer::compareTo).orElse(0);

        String output = numbers.contains(numberToSearch) ? "true" : String.valueOf(smallestNumber);

        System.out.println(output);

    }

    private static void readInputData(Scanner sc, int[] inputData, Deque<Integer> numbers) {
        int limitInputNumbers = inputData[0];

        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).limit(limitInputNumbers).forEach(numbers::push);

    }
}