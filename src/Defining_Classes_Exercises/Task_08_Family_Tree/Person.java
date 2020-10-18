package Defining_Classes_Exercises.Task_08_Family_Tree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthdayDate;
    private List<Person> parents;
    private List<Person> children;

public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthdayDate() {
        return this.birthdayDate;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }
}