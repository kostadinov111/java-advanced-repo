package Defining_Classes_Exercises.Task_06_Pokemon_Trainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemon;

    public Trainer(String name, List<Pokemon> collectionOfPokemon) {
        this.name = name;
        this.numberOfBadges = 0;
        this.collectionOfPokemon = collectionOfPokemon;
    }

    public void increaseNumberOfBadges() {
        ++this.numberOfBadges;
    }

    public void setCollectionOfPokemon(Pokemon pokemon) {
        this.collectionOfPokemon.add(pokemon);
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public List<Pokemon> getCollectionOfPokemon() {
        return this.collectionOfPokemon;
    }
}