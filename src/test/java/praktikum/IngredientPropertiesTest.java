package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientPropertiesTest {

    private static final Random RANDOM = new Random();
    private final IngredientType ingredientType;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientPropertiesTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] createIngredient() {
        // Генерация тестовых данных для параметризованных тестов
        return new Object[][]{
                {IngredientType.FILLING, RandomStringUtils.randomAlphabetic(10), getRandomPrice()},
                {IngredientType.SAUCE, RandomStringUtils.randomAlphabetic(10), getRandomPrice()}
        };
    }

    private static float getRandomPrice() {
        // Генерация случайной цены в диапазоне от 0 до 100
        return 0 + (100 * RANDOM.nextFloat());
    }

    @Test
    public void testGetIngredientType() {
        // Инициализация ингредиента и проверка его типа
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals("Тип ингредиента не совпадает", ingredientType, ingredient.getType());
    }

    @Test
    public void testGetName() {
        // Инициализация ингредиента и проверка его имени
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals("Имя ингредиента не совпадает", name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        // Инициализация ингредиента и проверка его цены
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals("Цена ингредиента не совпадает", price, ingredient.getPrice(), 0.01f); // Допуск точности в 0.01
    }
}
