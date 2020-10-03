package Defining_Classes_Exercises.Task_03_Speed_Racing;

public class Car {
    private String model;
    private double fuel;
    private double fuelPerKm;
    private double distanceTraveled;

    public Car(String model, double fuel, double fuelPerKm) {
        this.model = model;
        this.fuel = fuel;
        this.fuelPerKm = fuelPerKm;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return this.model;
    }

    public double getFuel() {
        return this.fuel;
    }

    public double getFuelPerKm() {
        return this.fuelPerKm;
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
}