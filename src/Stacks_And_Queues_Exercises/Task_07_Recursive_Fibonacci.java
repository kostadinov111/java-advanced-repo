package Stacks_And_Queues_Exercises;

import java.util.Scanner;

public class Task_07_Recursive_Fibonacci {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        long[] memoryRecursiveFibonacci = new long[n + 1];

        long result = recursiveFibonacci(n, memoryRecursiveFibonacci);
        System.out.println(result);

    }

    private static long recursiveFibonacci(int n, long[] memoryRecursiveFibonacci) {
        if (n <= 1) return 1;
        if (memoryRecursiveFibonacci[n] != 0) return memoryRecursiveFibonacci[n];
        return memoryRecursiveFibonacci[n] = recursiveFibonacci(n - 1, memoryRecursiveFibonacci) + recursiveFibonacci(n - 2, memoryRecursiveFibonacci);

    }
}