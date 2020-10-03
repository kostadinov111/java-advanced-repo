package Defining_Classes_Exercises.Task_03_Speed_Racing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Car> carsInfo = new LinkedHashMap<>();

        readCarInput(sc, carsInfo);

        StringBuilder output = new StringBuilder();

        trackingCars(sc, carsInfo, output);
        printCarsInfo(carsInfo, output);

    }

    private static void printCarsInfo(Map<String, Car> carsInfo, StringBuilder output) {
        carsInfo
                .forEach((model, car) -> output.append(String.format("%s %.2f %.0f%n",
                        car.getModel(), car.getFuel(), car.getDistanceTraveled())));

        System.out.println(output);
    }

    private static void trackingCars(Scanner sc, Map<String, Car> carsInfo, StringBuilder output) {
        String input;

        while (!"End".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            double amountOfKm = Double.parseDouble(tokens[2]);
            driveCar(model, amountOfKm, carsInfo, output);
        }

    }

    private static void driveCar(String model, double amountOfKm, Map<String, Car> carsInfo, StringBuilder output) {
        double currentFuel = carsInfo.get(model).getFuel();
        double fuelPerKm = carsInfo.get(model).getFuelPerKm();
        double currentDistanceTraveled = carsInfo.get(model).getDistanceTraveled();

        double usedFuel = amountOfKm * fuelPerKm;

        if (currentFuel - usedFuel >= 0) {
            carsInfo.get(model).setFuel(currentFuel - usedFuel);
            carsInfo.get(model).setDistanceTraveled(currentDistanceTraveled + amountOfKm);
        } else {
            output.append("Insufficient fuel for the drive").append(System.lineSeparator());
        }

    }

    private static void readCarInput(Scanner sc, Map<String, Car> carsInfo) {
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double fuelPerKm = Double.parseDouble(input[2]);

            carsInfo.put(model, new Car(model, fuel, fuelPerKm));
        }

    }
}