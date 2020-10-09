package Defining_Classes_Exercises.Task_06_Pokemon_Trainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public void decreaseHealth() {
        this.health -= 10;
    }

    public String getName() {
        return this.name;
    }

    public String getElement() {
        return this.element;
    }

    public int getHealth() {
        return this.health;
    }
}