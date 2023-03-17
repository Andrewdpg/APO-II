package model;

import java.util.LinkedList;

public class Recipe {

    LinkedList<Ingredient> ingredients;

    public Recipe() {
        ingredients = new LinkedList<>();
    }

    public void addIngredient(String name, int weight) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setWeight(weight);
        if (ingredients.contains(ingredient)) {
            int index = ingredients.indexOf(ingredient);
            ingredient.addWeight(ingredients.get(index).getWeight());
            ingredients.set(index, ingredient);
        } else {
            ingredients.add(ingredient);
        }
    }

    public void removeIngredient(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setWeight(0);
        if (ingredients.contains(ingredient)) {
            ingredients.removeFirstOccurrence(ingredient);
        }
    }

    public boolean contains(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setWeight(0);
        return ingredients.contains(ingredient);
    }

    public int weightOf(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setWeight(0);
        return ingredients.get(ingredients.indexOf(ingredient)).getWeight();
    }

    public Ingredient getLast() {
        return ingredients.getLast();
    }

}
