package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import exception.NegativeNumberException;

public class IngredientTest {

    Ingredient ingredient;

    public void setupStage1() {
        ingredient = new Ingredient();
        ingredient.setName("Tomate");
        ingredient.setWeight(245);
    }

    @Test
    public void addCorrectWeightTesting() {
        setupStage1();

        ingredient.addWeight(54);

        assertEquals(299, ingredient.getWeight());
    }

    @Test
    public void addNegativeWeightTesting() {
        setupStage1();

        assertThrows(NegativeNumberException.class, () -> ingredient.addWeight(-100));
        assertEquals(245, ingredient.getWeight());
    }

    @Test
    public void removeCorrectWeightTesting(){
        setupStage1();

        ingredient.removeWeight(45);

        assertEquals(200, ingredient.getWeight());
    }

    @Test
    public void removeNegativeWeightTesting() {
        setupStage1();

        assertThrows(NegativeNumberException.class, () -> ingredient.addWeight(-100));
        assertEquals(245, ingredient.getWeight());
    }
}
