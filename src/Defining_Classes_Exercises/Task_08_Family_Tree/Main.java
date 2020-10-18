package Defining_Classes_Exercises.Task_08_Family_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputPersonInfo = reader.readLine();
            Person person = new Person();

            readPersonInfo(reader, inputPersonInfo, person);

            Map<String, List<String>> parents = new LinkedHashMap<>();
            Map<String, List<String>> children = new LinkedHashMap<>();
            Map<String, String> people = new LinkedHashMap<>();

            readFamilyTreeInfo(reader, parents, children, people, person);
            fulfillInfoInFamilyTree(parents, people, person, "parent");
            fulfillInfoInFamilyTree(children, people, person, "child");
            printFamilyTree(person);

        }
    }

    private static void printFamilyTree(Person person) {
        StringBuilder output = new StringBuilder();

        output.append(String.format("%s %s%n", person.getName(), person.getBirthdayDate()));
        output.append(String.format("Parents:%n"));

        for (Person parent : person.getParents()) {
            output.append(String.format("%s %s%n", parent.getName(), parent.getBirthdayDate()));
        }

        output.append(String.format("Children:%n"));

        for (Person child : person.getChildren()) {
            output.append(String.format("%s %s%n", child.getName(), child.getBirthdayDate()));
        }

        System.out.println(output);

    }

    private static void fulfillInfoInFamilyTree(Map<String, List<String>> parentsOrChildren, Map<String, String> people, Person person, String parentOrChild) {
        for (Map.Entry<String, List<String>> personEntry : parentsOrChildren.entrySet()) {

            for (Map.Entry<String, String> aPersonEntry : people.entrySet()) {

                if (personEntry.getKey().equals(aPersonEntry.getKey())) {

                    for (String nameOrBirthDate : personEntry.getValue()) {

                        if (nameOrBirthDate.equals(person.getName()) || nameOrBirthDate.equals(person.getBirthdayDate())) {
                            Person parentOrChildPerson = new Person();
                            parentOrChildPerson.setName(aPersonEntry.getKey());
                            parentOrChildPerson.setBirthdayDate(aPersonEntry.getValue());

                            if (parentOrChild.equals("parent")) {
                                person.getParents().add(parentOrChildPerson);
                            } else if ("child".equals(parentOrChild)) {
                                person.getChildren().add(parentOrChildPerson);
                            }

                            break;
                        }

                    }

                }

                if (personEntry.getKey().equals(aPersonEntry.getValue())) {

                    for (String nameOrBirthDate : personEntry.getValue()) {

                        if (nameOrBirthDate.equals(person.getName()) || nameOrBirthDate.equals(person.getBirthdayDate())) {
                            Person parentOrChildPerson = new Person();
                            parentOrChildPerson.setName(aPersonEntry.getKey());
                            parentOrChildPerson.setBirthdayDate(aPersonEntry.getValue());

                            if (parentOrChild.equals("parent")) {
                                person.getParents().add(parentOrChildPerson);
                            } else if ("child".equals(parentOrChild)) {
                                person.getChildren().add(parentOrChildPerson);
                            }

                            break;
                        }

                    }

                }

            }

        }

    }

    private static void readFamilyTreeInfo(BufferedReader reader, Map<String, List<String>> parents, Map<String, List<String>> children, Map<String, String> people, Person person) throws IOException {
        String input;

        while (!"End".equals(input = reader.readLine())) {

            if (input.contains(" - ")) {
                String[] tokens = input.split(" - ");
                String parentSide = tokens[0];
                String childrenSide = tokens[1];

                parents.putIfAbsent(parentSide, new ArrayList<>());
                parents.get(parentSide).add(childrenSide);

                children.putIfAbsent(childrenSide, new ArrayList<>());
                children.get(childrenSide).add(parentSide);

            } else {
                String[] tokens = input.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String birthday = tokens[2];
                people.put(name, birthday);

            }

        }

        // fulfill Person info about name and birthday
        for (Map.Entry<String, String> aPerson : people.entrySet()) {

            if (aPerson.getKey().equals(person.getName()) || aPerson.getValue().equals(person.getBirthdayDate())) {
                person.setName(aPerson.getKey());
                person.setBirthdayDate(aPerson.getValue());
                break;
            }

        }

        people.remove(person.getName());

    }

    private static void readPersonInfo(BufferedReader reader, String inputPersonInfo, Person person) {

        if (inputPersonInfo.contains("/")) {
            person.setBirthdayDate(inputPersonInfo);
        } else {
            person.setName(inputPersonInfo);
        }

    }
}