package Defining_Classes_Exercises.Task_05_Car_Salesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        readEnginesInput(sc, engines);
        readCarsInput(sc, engines, cars);
        printCarsInfo(cars);

    }

    private static void printCarsInfo(List<Car> cars) {
        cars
                .forEach(System.out::println);
    }

    private static void readCarsInput(Scanner sc, Map<String, Engine> engines, List<Car> cars) {
        int m = Integer.parseInt(sc.nextLine());

        while (m-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String model = tokens[0];
            String engineModel = tokens[1];

            if (tokens.length == 2) {
                cars.add(new Car(model, engines.get(engineModel)));
            } else if (tokens.length == 4) {
                cars.add(new Car(model, engines.get(engineModel), Integer.parseInt(tokens[2]), tokens[3]));
            } else if (tokens.length == 3) {
                try {
                    int weight = Integer.parseInt(tokens[2]);
                    cars.add(new Car(model, engines.get(engineModel), weight));
                } catch (NumberFormatException ex) {
                    cars.add(new Car(model, engines.get(engineModel), tokens[2]));
                }
            }

        }

    }

    private static void readEnginesInput(Scanner sc, Map<String, Engine> engines) {
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            if (tokens.length == 2) {
                engines.put(model, new Engine(model, power));
            } else if (tokens.length == 4) {
                engines.put(model, new Engine(model, power, Integer.parseInt(tokens[2]), tokens[3]));
            } else if (tokens.length == 3) {
                try {
                    int displacement = Integer.parseInt(tokens[2]);
                    engines.put(model, new Engine(model, power, displacement));
                } catch (NumberFormatException ex) {
                    engines.put(model, new Engine(model, power, tokens[2]));
                }
            }

        }

    }
}