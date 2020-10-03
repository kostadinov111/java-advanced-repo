package Defining_Classes_Exercises.Task_02_Company_Roster;

public class Department {
    private double totalSalary;
    private int count;


    public void setTotalSalary(double salary) {
        this.totalSalary += salary;
    }

    public void setCount(int count) {
        this.count += count;
    }

    public double getTotalSalary() {
        return this.totalSalary / this.count;
    }
}