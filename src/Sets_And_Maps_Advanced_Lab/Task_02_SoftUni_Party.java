package Sets_And_Maps_Advanced_Lab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task_02_SoftUni_Party {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<String> reservationsVIP =  new HashSet<>();
        Set<String> reservationsRegular =  new HashSet<>();

        int reservationNumbersLen = 8;

        String input;

        while (!"PARTY".equals(input = sc.nextLine())) {
            char firstSymbol = input.charAt(0);
            int reservationLen = input.length();

            if (Character.isDigit(firstSymbol) && reservationLen == reservationNumbersLen) {
                reservationsVIP.add(input);
            } else if (reservationLen == reservationNumbersLen) {
                reservationsRegular.add(input);
            }

        }

        while (!"END".equals(input = sc.nextLine())) {
            reservationsVIP.remove(input);
            reservationsRegular.remove(input);
        }

        System.out.println(reservationsVIP.size() + reservationsRegular.size());

        reservationsVIP
                .stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);

        reservationsRegular
                .stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);

    }
}