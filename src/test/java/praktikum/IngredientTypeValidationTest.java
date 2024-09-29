package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeValidationTest {

    // Ожидаемые значения для ингредиентов
    private static final String EXPECTED_SAUCE = "SAUCE";
    private static final String EXPECTED_FILLING = "FILLING";

    @Test
    public void testSauceType() {
        // Проверка строкового представления типа SAUCE
        String actualSauceType = IngredientType.SAUCE.toString();
        assertEquals("Expected SAUCE type to match its string representation.", EXPECTED_SAUCE, actualSauceType);
    }

    @Test
    public void testFillingType() {
        // Проверка строкового представления типа FILLING
        String actualFillingType = IngredientType.FILLING.toString();
        assertEquals("Expected FILLING type to match its string representation.", EXPECTED_FILLING, actualFillingType);
    }
}
