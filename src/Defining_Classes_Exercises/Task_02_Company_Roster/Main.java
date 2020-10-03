package Defining_Classes_Exercises.Task_02_Company_Roster;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        readEmployeesInfo(sc, employees);

        Map<String, Department> departmentSalaries = new HashMap<>();

        readDepartmentAverageSalaries(employees, departmentSalaries);
        printEmployeesInfo(employees, departmentSalaries);

    }

    private static void printEmployeesInfo(List<Employee> employees, Map<String, Department> departmentSalaries) {
        double maxAverageSalary = 0.0d;
        String maxDepartment = "";

        for (Map.Entry<String, Department> entry : departmentSalaries.entrySet()) {
            if (entry.getValue().getTotalSalary() > maxAverageSalary) {
                maxAverageSalary = entry.getValue().getTotalSalary();
                maxDepartment = entry.getKey();
            }
        }

        StringBuilder output = new StringBuilder();
        output.append(String.format("Highest Average Salary: %s%n", maxDepartment));

        String finalMaxDepartment = maxDepartment;

        employees
                .stream()
                .filter(employee -> employee.getDepartment().equals(finalMaxDepartment))
                .sorted((employee1, employee2) -> Double.compare(employee2.getSalary(), employee1.getSalary()))
                .forEach(employee -> output.append(String.format("%s %.2f %s %d%n",
                        employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge())));

        System.out.println(output);

    }

    private static void readDepartmentAverageSalaries(List<Employee> employees, Map<String, Department> departmentSalaries) {

        for (Employee employee : employees) {
            String department = employee.getDepartment();
            departmentSalaries.putIfAbsent(department, new Department());
            departmentSalaries.get(department).setTotalSalary(employee.getSalary());
            departmentSalaries.get(department).setCount(1);
        }

    }

    private static void readEmployeesInfo(Scanner sc, List<Employee> employees) {
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employees.add(new Employee(name, salary, position, department, email, age));
            } else if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    String email = tokens[4];
                    employees.add(new Employee(name, salary, position, department, email));
                } else {
                    int age = Integer.parseInt(tokens[4]);
                    employees.add(new Employee(name, salary, position, department, age));
                }
            } else if (tokens.length == 4) {
                employees.add(new Employee(name, salary, position, department));
            }
        }

    }
}