package model;

import exception.NegativeNumberException;

public class Ingredient {

    private String name;
    private int weight;

    public Ingredient(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public void addWeight(int weight) {
        if (weight < 0) {
            throw new NegativeNumberException();
        }
        this.weight += weight;
    }

    public void removeWeight(int weight) {
        if (weight < 0) {
            throw new NegativeNumberException();
        }
        this.weight -= weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ingredient) {
            return ((Ingredient) obj).getName().equals(this.name);
        }
        return false;
    }
}
