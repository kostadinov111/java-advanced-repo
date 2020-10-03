package Defining_Classes_Exercises.Task_01_Opinion_Poll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Defining_Classes_Exercises.Task_01_Opinion_Poll.Person> persons = new ArrayList<>();

        readPersonsList(sc, persons);
        printFilteredPersonsList(persons);

    }

    private static void printFilteredPersonsList(List<Defining_Classes_Exercises.Task_01_Opinion_Poll.Person> persons) {
        persons
                .stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Defining_Classes_Exercises.Task_01_Opinion_Poll.Person::getName))
                .forEach(System.out::println);
    }

    private static void readPersonsList(Scanner sc, List<Defining_Classes_Exercises.Task_01_Opinion_Poll.Person> persons) {
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            persons.add(new Person(name, age));
        }

    }
}