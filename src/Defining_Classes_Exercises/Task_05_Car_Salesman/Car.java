package Defining_Classes_Exercises.Task_05_Car_Salesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    public String getModel() {
        return this.model;
    }

    public String getWeight() {
        return this.weight == -1 ? "n/a" : String.valueOf(this.weight);
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(this.getModel())
                .append(":")
                .append(System.lineSeparator())
                .append(this.engine.toString())
                .append("Weight: ")
                .append(this.getWeight())
                .append(System.lineSeparator())
                .append("Color: ")
                .append(this.getColor());

        return output.toString();
    }
}