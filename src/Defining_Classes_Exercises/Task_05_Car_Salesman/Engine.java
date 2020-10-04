package Defining_Classes_Exercises.Task_05_Car_Salesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return this.model;
    }

    public int getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement == -1 ? "n/a" : String.valueOf(this.displacement);
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(this.getModel())
                .append(":")
                .append(System.lineSeparator())
                .append("Power: ")
                .append(this.getPower())
                .append(System.lineSeparator())
                .append("Displacement: ")
                .append(this.getDisplacement())
                .append(System.lineSeparator())
                .append("Efficiency: ")
                .append(this.getEfficiency())
                .append(System.lineSeparator());

        return output.toString();
    }
}