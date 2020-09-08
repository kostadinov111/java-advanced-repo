package Sets_And_Maps_Advanced_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Task_03_Periodic_table {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<String> chemicalCompounds = new TreeSet<>();

        readChemicalCompounds(sc, chemicalCompounds);
        printChemicalCompounds(chemicalCompounds);

    }

    private static void printChemicalCompounds(Set<String> chemicalCompounds) {
        System.out.println(String.join(" ", chemicalCompounds));
    }

    private static void readChemicalCompounds(Scanner sc, Set<String> chemicalCompounds) {
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] chemicals = sc.nextLine().split("\\s+");
            chemicalCompounds.addAll(Arrays.asList(chemicals));
        }

    }
}