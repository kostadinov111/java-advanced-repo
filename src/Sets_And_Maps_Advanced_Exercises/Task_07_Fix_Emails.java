package Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_07_Fix_Emails {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, String> namesEmails = new LinkedHashMap<>();

        readNamesAndEmails(sc, namesEmails);
        printNamesAndEmails(namesEmails);

    }

    private static void printNamesAndEmails(Map<String, String> namesEmails) {
        namesEmails
                .forEach((key, value) -> {
                    System.out.println(String.format("%s -> %s", key, value));
                });
    }

    private static void readNamesAndEmails(Scanner sc, Map<String, String> namesEmails) {
        String name;

        while (!"stop".equals(name = sc.nextLine())) {
            String email = sc.nextLine();

            String regex = "^[A-Za-z]+@[A-Za-z]+\\.([A-Za-z]+)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if (matcher.find()) {
                String domain = matcher.group(1);
                if (!"us".equals(domain) && !"uk".equals(domain) && !"com".equals(domain)) {
                    namesEmails.put(name, email);
                }
            }

        }

    }
}