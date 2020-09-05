package Sets_And_Maps_Advanced_Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Task_01_Parking_Lot {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String input;

        while (!"END".equals(input = sc.nextLine())) {
            String[] tokens = input.split(",\\s+");
            String token = tokens[0];
            String carNumber = tokens[1];

            if ("IN".equals(token)) {
                parkingLot.add(carNumber);
            } else if ("OUT".equals(token)) {
                parkingLot.remove(carNumber);
            }
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : parkingLot) {
                System.out.println(carNumber);
            }
        }

    }
}