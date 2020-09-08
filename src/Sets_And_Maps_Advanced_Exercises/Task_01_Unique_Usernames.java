package Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Task_01_Unique_Usernames {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        readUsernames(sc, usernames);
        printUsernames(usernames);

    }

    private static void printUsernames(Set<String> usernames) {
        usernames
                .forEach(System.out::println);
    }

    private static void readUsernames(Scanner sc, Set<String> usernames) {
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String username = sc.nextLine();
            usernames.add(username);
        }
    }
}