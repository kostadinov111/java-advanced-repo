package Stacks_And_Queues_Exercises;

import java.util.*;

public class Task_06_Balanced_Parentheses {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<Character> parentheses = new ArrayDeque<>();
        readInputAndPrintResult(sc, parentheses);

    }

    private static void readInputAndPrintResult(Scanner sc, Deque<Character> parentheses) {
        String input = sc.nextLine();
        String output = "YES";

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if ('(' == symbol || '{' == symbol || '[' == symbol) {
                parentheses.push(symbol);
            } else {
                if (parentheses.isEmpty()) {
                    output = "NO";
                    break;
                } else {
                    char topSymbol = parentheses.pop();
                    if (!('(' == topSymbol && ')' == symbol || '{' == topSymbol && '}' == symbol || '[' == topSymbol && ']' == symbol)) {
                        output = "NO";
                        break;
                    }
                }
            }
        }

        System.out.println(output);
    }

}