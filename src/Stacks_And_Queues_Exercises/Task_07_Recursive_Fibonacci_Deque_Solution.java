package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task_07_Recursive_Fibonacci_Deque_Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<Long> recursiveFibonacci = new ArrayDeque<>();

        recursiveFibonacci.push(1L);
        recursiveFibonacci.push(1L);

        long number = Long.parseLong(sc.nextLine());
        printRecursiveFibonacci(number, recursiveFibonacci);

    }

    private static void printRecursiveFibonacci(long number, Deque<Long> recursiveFibonacci) {
        for (int i = 0; i < number - 1; i++) {
            long num1 = recursiveFibonacci.pop();
            long num2 = recursiveFibonacci.pop();
            long num3 = num1 + num2;

            recursiveFibonacci.push(num2);
            recursiveFibonacci.push(num1);
            recursiveFibonacci.push(num3);
        }

        System.out.println(recursiveFibonacci.peek());
    }
}