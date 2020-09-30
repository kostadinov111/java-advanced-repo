package Defining_Classes_Lab.Task_01_Car_Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            if (tokens.length == 3) {
                String make = tokens[0];
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);

                Car car = new Car(make, model, horsePower);
                cars.add(car);
            } else if (tokens.length == 1) {
                String make = tokens[0];
                Car car = new Car(make);
                cars.add(car);
            }

        }

        StringBuilder output = new StringBuilder();

        for (Car car : cars) {
            output.append(car.getInfo()).append(System.lineSeparator());
        }

        System.out.println(output);

    }
}