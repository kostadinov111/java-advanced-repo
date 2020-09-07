package Sets_And_Maps_Advanced_Lab;

import java.util.*;

public class Task_05_Average_Students_Grades {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, List<Double>> studentRecords = new TreeMap<>();

        readStudentRecords(sc, studentRecords);
        printStudentRecords(studentRecords);

    }

    private static void printStudentRecords(Map<String, List<Double>> studentRecords) {
        for (Map.Entry<String, List<Double>> entry : studentRecords.entrySet()) {
            System.out.print(String.format("%s -> ", entry.getKey()));
            double avg = 0.0d;

            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(String.format("%.2f ", entry.getValue().get(i)));
                avg += entry.getValue().get(i);
            }

            double average = avg / entry.getValue().size();
            System.out.println(String.format("(avg: %.2f)", average));

        }
    }

    private static void readStudentRecords(Scanner sc, Map<String, List<Double>> studentRecords) {
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String studentName = tokens[0];
            double studentGrade = Double.parseDouble(tokens[1]);

            studentRecords.putIfAbsent(studentName, new ArrayList<>());
            studentRecords.get(studentName).add(studentGrade);
        }

    }
}