package Defining_Classes_Exercises.Task_07_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Person> persons = new HashMap<>();

        readPersonInput(sc, persons);
        printPersonInfo(sc, persons);

    }

    private static void printPersonInfo(Scanner sc, Map<String, Person> persons) {
        String person = sc.nextLine();
        System.out.println(persons.get(person));

    }

    private static void readPersonInput(Scanner sc, Map<String, Person> persons) {
        String input;

        while (!"End".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String token = tokens[1];

            switch (token) {
                case "company": {
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    persons.putIfAbsent(personName, new Person(personName));
                    persons.get(personName).setCompany(new Company(companyName, department, salary));
                }
                break;
                case "pokemon": {
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    persons.putIfAbsent(personName, new Person(personName));
                    persons.get(personName).getPokemonList().putIfAbsent(pokemonName, pokemonType);
                }
                break;
                case "parents": {
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    persons.putIfAbsent(personName, new Person(personName));
                    persons.get(personName).getParents().putIfAbsent(parentName, parentBirthday);
                }
                break;
                case "children": {
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    persons.putIfAbsent(personName, new Person(personName));
                    persons.get(personName).getChildren().putIfAbsent(childName, childBirthday);
                }
                break;
                case "car": {
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    persons.putIfAbsent(personName, new Person(personName));
                    persons.get(personName).getCar().putIfAbsent(carModel, carSpeed);
                    persons.get(personName).getCar().put(carModel, carSpeed);
                }
                break;
                default:
                    throw new IllegalStateException("Unknown value of tokens[1] -> " + token);
            }
        }

    }
}