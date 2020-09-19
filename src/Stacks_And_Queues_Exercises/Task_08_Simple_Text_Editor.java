package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task_08_Simple_Text_Editor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<String> commandsLog = new ArrayDeque<>();

        readInputAndProcessCommands(sc, commandsLog);

    }

    private static void readInputAndProcessCommands(Scanner sc, Deque<String> commandsLog) {
        int n = Integer.parseInt(sc.nextLine());
        String text = "";
        commandsLog.push(text);

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "1": {
                    String addedText = tokens[1];
                    text += addedText;
                    commandsLog.push(text);
                }
                break;
                case "2": {
                    int count = Integer.parseInt(tokens[1]);
                    text = text.substring(0, text.length() - count);
                    commandsLog.push(text);
                }
                break;
                case "3": {
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(String.format("%c", text.charAt(index - 1)));
                }
                break;
                case "4": {
                    commandsLog.pop();
                    text = commandsLog.peek();
                }
                break;
                default:
                    throw new IllegalStateException("Unknown value of tokens[0] -> " + tokens[0]);
            }
        }

    }
}