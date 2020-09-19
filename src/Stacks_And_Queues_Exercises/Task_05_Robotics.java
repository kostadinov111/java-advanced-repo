package Stacks_And_Queues_Exercises;

import java.util.*;

public class Task_05_Robotics {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        Map<String, Integer> robots = new LinkedHashMap<>();
        Deque<String> products = new ArrayDeque<>();

        readRobotsInput(sc, robots);
        String initTime = sc.nextLine();
        readProducts(sc, products);

        int[] workingTimes = new int[robots.size()];

        productsProcessing(initTime, workingTimes, products ,robots);

    }

    private static void productsProcessing(String initTime, int[] workingTimes, Deque<String> products, Map<String, Integer> robots) {
        StringBuilder output = new StringBuilder();
        long currentTime = 0;

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            ++currentTime;
            decreasingProcessTime(workingTimes);
            boolean isTaskAssigned = false;

            for (int i = 0; i < workingTimes.length; i++) {
                if (workingTimes[i] == 0) {
                    int count = -1;

                    for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                        count++;
                        if (count == i) {
                            workingTimes[i] = robots.get(entry.getKey());
                            isTaskAssigned = true;
                            printInfo(entry.getKey(), currentProduct, initTime, currentTime, output);
                            break;
                        }
                    }

                    break;
                }
            }

            if (!isTaskAssigned) {
                products.offer(currentProduct);
            }

        }

        System.out.println(output);
    }

    private static void printInfo(String robotName, String product, String timestamp, long currentTime, StringBuilder output) {
        int hours = Integer.parseInt(timestamp.split(":")[0]);
        int minutes = Integer.parseInt(timestamp.split(":")[1]);
        int seconds = Integer.parseInt(timestamp.split(":")[2]);
        long totalTime = hours * 3600 + minutes * 60 + seconds + currentTime;

        long hh = totalTime / 3600 % 24;
        long mm = totalTime / 60 % 60;
        long ss = totalTime % 60;

        output.append(String.format("%s - %s [%02d:%02d:%02d]%n", robotName, product, hh, mm, ss));
    }

    private static void decreasingProcessTime(int[] workingTimes) {

        for (int i = 0; i < workingTimes.length; i++) {
            if (workingTimes[i] > 0) {
                --workingTimes[i];
            }
        }

    }

    private static void readProducts(Scanner sc, Deque<String> products) {
        String input;

        while (!"End".equals(input = sc.nextLine())) {
            products.offer(input);
        }

    }

    private static void readRobotsInput(Scanner sc, Map<String, Integer> robots) {
        String[] robotsInput = sc.nextLine().split(";");

        for (String robotInfo : robotsInput) {
            String robotName = robotInfo.split("-")[0];
            int processTime = Integer.parseInt(robotInfo.split("-")[1]);
            robots.put(robotName, processTime);
        }

    }
}