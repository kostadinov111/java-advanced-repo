package Defining_Classes_Exercises.Task_06_Pokemon_Trainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        readTrainersInput(sc, trainers);
        readPokemonElements(sc, trainers);
        printTrainers(trainers);
    }

    private static void printTrainers(Map<String, Trainer> trainers) {
        StringBuilder output = new StringBuilder();

        trainers
                .entrySet()
                .stream()
                .sorted((amountOfBadges1, amountOfBadges2) -> Integer.compare(amountOfBadges2.getValue().getNumberOfBadges(), amountOfBadges1.getValue().getNumberOfBadges()))
                .forEach(trainer -> output.append(String.format("%s %d %d%n", trainer.getKey(), trainer.getValue().getNumberOfBadges(), trainer.getValue().getCollectionOfPokemon().size())));

        System.out.println(output);

    }

    private static void readPokemonElements(Scanner sc, Map<String, Trainer> trainers) {
        String currentElement;

        while (!"End".equals(currentElement = sc.nextLine())) {

            Map<String, List<String>> currentElements = readCurrentPokemonElements(trainers);

            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {

                if (currentElements.containsKey(trainer.getKey()) && currentElements.get(trainer.getKey()).contains(currentElement)) {
                    trainer.getValue().increaseNumberOfBadges();
                } else {

                    for (Pokemon pokemon : trainer.getValue().getCollectionOfPokemon()) {
                        pokemon.decreaseHealth();
                    }

                    trainer.getValue().getCollectionOfPokemon().removeAll(trainer.getValue().getCollectionOfPokemon().stream().filter(p -> p.getHealth() <= 0).collect(Collectors.toList()));
                }

            }

        }

    }

    private static Map<String, List<String>> readCurrentPokemonElements(Map<String, Trainer> trainers) {
        Map<String, List<String>> currentElements = new LinkedHashMap<>();

        for (Trainer trainer : trainers.values()) {

            for (Pokemon pokemon : trainer.getCollectionOfPokemon()) {
                currentElements.putIfAbsent(trainer.getName(), new ArrayList<>());
                currentElements.get(trainer.getName()).add(pokemon.getElement());
            }
            
        }

        return currentElements;

    }

    private static void readTrainersInput(Scanner sc, Map<String, Trainer> trainers) {
        String input;

        while (!"Tournament".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");
            trainers.putIfAbsent(tokens[0], new Trainer(tokens[0], new ArrayList<>()));
            trainers.get(tokens[0]).setCollectionOfPokemon(new Pokemon(tokens[1], tokens[2], Integer.parseInt(tokens[3])));
        }

    }
}