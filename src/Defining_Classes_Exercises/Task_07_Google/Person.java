package Defining_Classes_Exercises.Task_07_Google;

import java.util.LinkedHashMap;
import java.util.Map;

public class Person {
    private String personName;
    private Company company;
    private Map<String, String> pokemonList;
    private Map<String, String> parents;
    private Map<String, String> children;
    private Map<String, Integer> car;

    public Person(String personName) {
        this.personName = personName;
        this.company = new Company();
        this.pokemonList = new LinkedHashMap<>();
        this.parents = new LinkedHashMap<>();
        this.children = new LinkedHashMap<>();
        this.car = new LinkedHashMap<>();
    }

    public Map<String, String> getPokemonList() {
        return this.pokemonList;
    }

    public Map<String, String> getParents() {
        return this.parents;
    }

    public Map<String, String> getChildren() {
        return this.children;
    }

    public Map<String, Integer> getCar() {
        return this.car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(this.personName).append(System.lineSeparator());

        if (this.company.getCompanyName() == null) {
            output.append("Company:").append(System.lineSeparator());
        } else {
            output.append("Company:").append(System.lineSeparator()).append(this.company.toString()).append(System.lineSeparator());
        }

        if (this.car.size() == 0) {
            output.append("Car:").append(System.lineSeparator());
        } else {
            output.append("Car:").append(System.lineSeparator());
            this.car.forEach((carModel, carSpeed) -> output.append(String.format("%s %d", carModel, carSpeed)).append(System.lineSeparator()));
        }

        if (this.pokemonList.size() > 0) {
            output.append("Pokemon:").append(System.lineSeparator());
            this.pokemonList.forEach((pokemonName, pokemonType) -> output.append(pokemonName).append(" ").append(pokemonType).append(System.lineSeparator()));
        } else {
            output.append("Pokemon:").append(System.lineSeparator());
        }

        if (this.parents.size() > 0) {
            output.append("Parents:").append(System.lineSeparator());
            this.parents.forEach((parentName, parentBirthday) -> output.append(parentName).append(" ").append(parentBirthday).append(System.lineSeparator()));
        } else {
            output.append("Parents:").append(System.lineSeparator());
        }

        if (this.children.size() > 0) {
            output.append("Children:").append(System.lineSeparator());
            this.children.forEach((childName, childBirthday) -> output.append(childName).append(" ").append(childBirthday).append(System.lineSeparator()));
        } else {
            output.append("Children:").append(System.lineSeparator());
        }

        return output.toString();
    }

}