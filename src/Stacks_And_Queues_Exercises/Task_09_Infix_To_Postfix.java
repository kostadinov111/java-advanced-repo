package Stacks_And_Queues_Exercises;

import java.util.*;

public class Task_09_Infix_To_Postfix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> precedence = new LinkedHashMap<>();
        precedence.put("-", 2);
        precedence.put("+", 2);
        precedence.put("*", 3);
        precedence.put("/", 3);
        precedence.put("(", 1);

        Deque<String> output = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();

        String[] tokens = sc.nextLine().split("\\s+");
        for (String token : tokens) {

            if (Character.isLetterOrDigit(token.charAt(0))) {
                output.offer(token);

            } else if (token.charAt(0) == '(') {

                operators.push(token);

            } else if (token.charAt(0) == ')') {

                while (!operators.isEmpty() && operators.peek().charAt(0) != '(') {
                    output.offer(operators.pop());
                }

                operators.pop();

            } else if (operators.isEmpty() || precedence.get(token) > precedence.get(operators.peek())) {

                operators.push(token);

            } else if (operators.isEmpty() || precedence.get(token) <= precedence.get(operators.peek())) {

                while (!operators.isEmpty() && precedence.get(token) <= precedence.get(operators.peek())) {
                    output.offer(operators.pop());
                }

                operators.push(token);

            }
        }

        System.out.print(String.join(" ", output));
        System.out.print(" ");
        System.out.println(String.join(" ", operators));

    }
}