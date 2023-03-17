package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class RecipeTest {

    Recipe recipe;

    public void setupStage1() {
        recipe = new Recipe();
    }

    public void setupStage2() {
        recipe = new Recipe();
        recipe.addIngredient("Cebolla", 315);
        recipe.addIngredient("Ajo", 58);
        recipe.addIngredient("Arroz", 520);
    }

    @Test
    public void addUniqueIngredientTest() {
        setupStage1();

        recipe.addIngredient("Sal", 12);

        assertTrue(recipe.contains("Sal"));
        assertEquals(12, recipe.weightOf("Sal"));
    }

    @Test
    public void addMultipleIngredientsTest() {
        setupStage2();

        recipe.addIngredient("Pimienta", 6);

        assertEquals(new Ingredient("Pimienta", 6), recipe.getLast());
    }

    @Test
    public void addExistentIngredientTest() {
        setupStage2();

        recipe.addIngredient("Ajo", 21);

        assertTrue(recipe.contains("Ajo"));
        assertEquals(79,recipe.weightOf("Ajo"));
    }

    @Test
    public void removeIngredientTest(){
        setupStage2();

        recipe.removeIngredient("Ajo");

        assertFalse(recipe.contains("Ajo"));
    }
}
