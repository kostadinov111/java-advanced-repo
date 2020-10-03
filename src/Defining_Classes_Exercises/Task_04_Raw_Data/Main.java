package Defining_Classes_Exercises.Task_04_Raw_Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        readCarsInput(sc, cars);

        StringBuilder output = new StringBuilder();

        printCarsInfo(sc, cars, output);
    }

    private static void printCarsInfo(Scanner sc, List<Car> cars, StringBuilder output) {
        String command = sc.nextLine();

        if ("fragile".equals(command)) {
            cars
                    .stream()
                    .filter(car -> car.getCargoType().equals("fragile") && car.getTire1Pressure() < 1 || car.getTire2Pressure() < 1 || car.getTire3Pressure() < 1 || car.getTire4Pressure() < 1)
                    .forEach(car -> output.append(car.getModel()).append(System.lineSeparator()));
        } else if ("flamable".equals(command)) {
            cars
                    .stream()
                    .filter(car -> car.getCargoType().equals("flamable") && car.getEnginePower() > 250)
                    .forEach(car -> output.append(car.getModel()).append(System.lineSeparator()));
        }

        System.out.println(output);

    }

    private static void readCarsInput(Scanner sc, List<Car> cars) {
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);
            cars.add(new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age));
        }

    }
}