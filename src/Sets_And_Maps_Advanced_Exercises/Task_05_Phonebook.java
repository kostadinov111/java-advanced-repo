package Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_05_Phonebook {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        readPhonebook(sc, phonebook);
        searchPhonebook(sc, phonebook);

    }

    private static void searchPhonebook(Scanner sc, Map<String, String> phonebook) {
        String name;
        StringBuilder output = new StringBuilder();

        while (!"stop".equals(name = sc.nextLine())) {

            if (phonebook.containsKey(name)) {
                output.append(String.format("%s -> %s", name, phonebook.get(name))).append("\n");
            } else {
                output.append(String.format("Contact %s does not exist.", name)).append("\n");
            }

        }

        System.out.print(output);

    }

    private static void readPhonebook(Scanner sc, Map<String, String> phonebook) {
        String input;

        while (!"search".equals(input = sc.nextLine())) {

            String regex = "(?<name>[A-Za-z()]+)(-)(?<phoneNumber>[\\d/+]+)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String phone = matcher.group("phoneNumber");
                phonebook.put(name, phone);
            }

        }

    }
}